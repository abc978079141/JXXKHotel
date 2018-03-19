package com.gsh.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class LoginInterceptor implements HandlerInterceptor  { 
	   private static final String[] IGNORE_URI = {"/index.jsp", "download.jsp","/login/login.do", "/zhuce.jsp","/checkname.do","agree.html","/gettelmsg.do","/reg.do"};
	 // private final String USER ="user";  
	  //拦截前处理  
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
	        String url = request.getRequestURL().toString();
	        System.out.println(">>>: " + url);
	        for (String s : IGNORE_URI) {
	            if (url.contains(s)) {
	               return true;
	            }
	        }
				String username = (String) request.getSession().getAttribute("username");  
	            if (username != null)return true;
	    	    response.sendRedirect("index.jsp");
	    	    return false;
	  }  
	  //拦截后处理  
	  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception {
		  
		  
	  }  
	  //全部完成后处理  
	  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception { }  
	}  



