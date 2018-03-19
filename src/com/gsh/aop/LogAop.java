package com.gsh.aop;


import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gsh.model.Log;
import com.gsh.model.User;
import com.gsh.service.LogSerDao;
import com.gsh.util.DateUtil;
import com.gsh.util.IpUtil;
@Component
@Aspect
public class LogAop {
	private LogSerDao logService;
	@Resource
	public void setLogService(LogSerDao logService) {
		this.logService = logService;
	}
	public LogAop() {
		super();
	}
	/**
	 * 
	 *<p>Description:
     * 删除业务逻辑方法切入点 
     * 此处拦截要拦截到具体的莫一个模块
     * 如deleteUser方法。则删除user的时候会记录日志
     * deleteRole时删除role会记录日志
     *</p>
	 */
	@Pointcut("execution(* com.gsh.service.*.delete*(..))")
	public void deleteServiceCall(){}
	
	/**
	 * 
	 *<p>Description:修改业务逻辑方法切入点</p>
	 */
    @Pointcut("execution(* com.gsh.service.*.update*(..))")  
    public void updateServiceCall() { } 
    
    
	@Before("deleteServiceCall()")
	public void deleteMethod(JoinPoint jp){
		System.out.println("before aop loading......");
	}
	
	@AfterReturning("deleteServiceCall()")
	public void doafter(JoinPoint jp) throws Exception{
		/*User user=(User) jp.getArgs()[0];
		User user= (User) request.getSession().getAttribute("User");;
		String userName=user.getUsername();
		String nowtime=df.format(new Date());
		String act=jp.getSignature().getName();
		*/
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	User currentUser = (User) request.getSession().getAttribute("User");
        //判断参数  
        if(jp.getArgs() == null){//没有参数  
            return;  
        }  
        //获取方法名  
        //String methodName = joinPoint.getSignature().getName();  
        String className = jp.getArgs()[0].getClass().getName();
        //获取操作内容  
		className = className.substring(className.lastIndexOf(".") + 1);
        String opContent = adminOptionContent(jp.getArgs(), "删除");  
        //创建日志对象  
        Log log = new Log();
        log.setModule(className.toLowerCase());
        log.setUserName(currentUser.getUsername()); 
        log.setCreateTime(DateUtil.getTime());//操作时间  
        log.setContent(opContent);//操作内容  
        log.setOperation("添加");//操作
        log.setHid(1);
        log.setIp(IpUtil.getIpAddr(request));
        logService.save(log);
	}
	
	 /** 
     * 管理员修改操作日志(后置通知) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */ 
    @AfterReturning(value="updateServiceCall()", argNames="rtv", returning="rtv")  
    public void updateServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{  
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	User currentUser = (User) request.getSession().getAttribute("currentUser");
       
          
        //判断参数  
        if(joinPoint.getArgs() == null){//没有参数  
            return;  
        }  
        //获取方法名  
        String className = joinPoint.getArgs()[0].getClass().getName();
		className = className.substring(className.lastIndexOf(".") + 1);
        //获取操作内容  
        String opContent = adminOptionContent(joinPoint.getArgs(), "修改");  
        Log log = new Log();  
        log.setModule(className.toLowerCase());
        log.setUserName(currentUser.getUsername()); 
        log.setCreateTime(DateUtil.getTime());//操作时间  
        log.setContent(opContent);//操作内容  
        log.setOperation("修改");//操作
        log.setIp(IpUtil.getIpAddr(request));
        logService.save(log);//添加日志  
    }  
    
	
	/**
	 * 使用Java反射来获取被拦截方法(insert、update)的参数值， 将参数值拼接为操作内容
	 */
	public String adminOptionContent(Object[] args, String type) throws Exception {
		if (args == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		Object info = args[0];
		String className = info.getClass().getName();
		className = className.substring(className.lastIndexOf(".") + 1);
		sb.append(type+className+" 属性名和值：");
		// 获取对象的所有方法
		Method[] methods = info.getClass().getDeclaredMethods();
		// 遍历方法，判断get方法
		for (Method method : methods) {
			String methodName = method.getName();
			// 判断是不是get方法
			if (methodName.indexOf("get") == -1) {// 不是get方法
				continue;// 不处理
			}
			Object rsValue = null;
			try {
				// 调用get方法，获取返回值
				rsValue = method.invoke(info);
				if (rsValue == null) {// 没有返回值
					continue;
				}
			} catch (Exception e) {
				continue;
			}
			// 将值加入内容中
			sb.append(" " + methodName.substring(3) + "-->" + rsValue + "  ");
		}
		return sb.toString();
	}
}
