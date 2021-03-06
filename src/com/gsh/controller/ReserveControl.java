package com.gsh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsh.model.Badcord;
import com.gsh.model.PageInfo;
import com.gsh.model.Reserve;
import com.gsh.model.Room;
import com.gsh.service.BadCordSerDao;
import com.gsh.service.BaseSerDao;
import com.gsh.service.ResSerDao;
import com.gsh.service.RoomSerDao;
import com.gsh.util.DateUtil;

/**
 * 预定管理
 * @author gsh
 *
 */
@Controller
@RequestMapping("res")
public class ReserveControl {
	private ResSerDao resSerDao;
	private RoomSerDao roomSerDao;
	private BadCordSerDao badCordSerDao;
	@Resource
	public void setResSerDao(ResSerDao resSerDao) {
		this.resSerDao = resSerDao;
	}
	
	@Resource
	public void setRoomSerDao(RoomSerDao roomSerDao) {
		this.roomSerDao = roomSerDao;
	}
	@Resource
	public void setBadCordSerDao(BadCordSerDao badCordSerDao) {
		this.badCordSerDao = badCordSerDao;
	}

	/**
	 * 预定
	 * @param r 自动匹配实体信息，参数名（例如name）必须和实体属性（name）名一致
	 * @return jackson自动处理的json 提示信息
	 */
	@RequestMapping("/olres.do")
	@ResponseBody
	public String olres(Reserve res,Room room,HttpSession session){
		if(null==res.getHid()){
			res.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
		}
		//得到预定下单的时间
		res.setRestime(DateUtil.getTime());
		//生成订单号
		res.setResnumber(DateUtil.getTimes());
		//预计抵达时间
		res.setStarttime(room.getStarttime());
		//预计保留时间
		res.setEndtime(room.getEndtime());
		//Map<String, String> map=new HashMap<String, String>();
		Room r2=roomSerDao.find("from Room as  r where r.roomnum ="+"'"+room.getRoomnum()+"'").get(0);
		r2.setRoomstate(2);
		//预计抵达时间
		r2.setStarttime(room.getStarttime());
		//预计保留时间
		r2.setEndtime(room.getEndtime());
		//保存预定订单信息
		resSerDao.save(res);
		//修改房间信息
		roomSerDao.save(r2);
		//map.put("tips", "success");
		return "success";
		//return "redirect:../index.jsp";
	}
	/**
	 * 接待中心的预定管理之订单中心列表信息的获取
	 * @param p 分页信息
	 * @param res 实体Reserve
	 * @return jackson 自动处理的reslist 信息
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public Map<String, Object> getlist(PageInfo p,Reserve res,String act,HttpSession session){
		Map<String, Object> map= new HashMap<String, Object>();
		res.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
		List<Reserve> reslist = resSerDao.find(res,p.getPage(),p.getRows());
		List<Reserve> newreslist = new ArrayList<Reserve>();
			for(Reserve r:reslist){
				String endtime=r.getEndtime();
				String nowtime=DateUtil.getTime();
				long timediff=DateUtil.getTimeSub(endtime, nowtime);
				if(DateUtil.compareDate(endtime, nowtime)&&timediff>=2){
					String remark="";
					if(r.getMemnum()!=null)
						remark+="详情：会员  ";
					else
						remark+="详情：普通宾客  ";
					remark+="逾期时间："+timediff+"小时";
					r.setResstate("逾期");
					r.setRemark(remark);
					resSerDao.update(r);
				}
					newreslist.add(r);
			}
		map.put("rows", newreslist);
		map.put("total", resSerDao.getTotal(res));
		return map;
	}
	
	/**
	 * 接待中心的预定管理之订单中心列表信息的获取
	 * @param p 分页信息
	 * @param res 实体Reserve
	 * @return jackson 自动处理的reslist 信息
	 */
	@RequestMapping("/checkin.do")
	public String checkin(int id,Model m){
		Room room =roomSerDao.get(Room.class, id);
		String roomnum=room.getRoomnum();
		Reserve res=new Reserve();
		res.setRoomnum(roomnum);
		res.setResstate("正常");
		Reserve resinfo=resSerDao.find(res).get(0);
		m.addAttribute("resinfo", resinfo);
		m.addAttribute("room", room);
		return "reception/checkin";
	}
	
	/**
	 * 
	*Description:<p style="color:red">订单中心 取消与还原订单</p>
	*@param resnumber 订单号（唯一）
	*@return
	 */
	@RequestMapping("/corb.do")
	@ResponseBody
	public String cancel(String resnumber,HttpSession session){
		//根据订单号查找订单
		List<Reserve> reslist=resSerDao.find("from  Reserve as r where r.resnumber="+"'"+resnumber+"'");
			//如果不唯一则报错
			if(reslist.size()>1)
				return "no";
		//取到预订订单详细信息
		Reserve res=reslist.get(0);
		//根据订单中的房间号获得房间详细信息
		Room room=roomSerDao.find("from Room as r where r.roomnum ="+"'"+res.getRoomnum()+"'").get(0);
		//判断房间状态（1：空房；2：预留)判断是还原还是取消订单、
		//如果是1，则是还原操作，修改订单状态为正常。
		if(room.getRoomstate()==1){
			long count=resSerDao.count("select count(*) from  Reserve as r where r.roomnum="+"'"+res.getRoomnum()+"'");
				if(count>1){
					return "no";
					}
				room.setRoomstate(2);
				res.setResstate("正常");
			}
		//如果是2，则是取消操作，修改订单状态为取消。
		else {
			room.setRoomstate(1);
			res.setResstate("取消");
		}
		roomSerDao.save(room);
		resSerDao.save(res);
		return "yes";
	}
	/**************************BADCORD****************************/
	/**
	 * 
	*Description:<p style="color:red">订单中心添加不良记录</p>
	*@param resnumber 订单号（唯一）
	*@return
	 */
	@RequestMapping("/addbadcord.do")
	@ResponseBody
	public String addbadcord(String resnumber,HttpSession session,String cordtype){
		int hid=Integer.parseInt(session.getAttribute("hid").toString());
		String bookkeeper=session.getAttribute("username").toString();
		//取到预订订单详细信息
		Reserve res=resSerDao.find("from  Reserve as r where r.resnumber="+"'"+resnumber+"' and r.hid ="+hid).get(0);
		Badcord bad=new Badcord(hid,DateUtil.getTimes(), res.getMemnum(), res.getResname(), cordtype, res.getRestel(), bookkeeper, res.getRemark(),DateUtil.getTime());
		badCordSerDao.save(bad);
		return "yes";
	}
	
	
	/**
	 * 
	 *<p>Description: 不良记录列表获取</p>
	 * @param p
	 * @param bad
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("getlistBAD.do")
	@ResponseBody
	public Map<String, Object> getlistBAD(PageInfo p,Badcord bad,HttpSession session) throws Exception{
		Map<String, Object> map= new HashMap<String, Object>();
		bad.setHid(Integer.parseInt(session.getAttribute("hid").toString()));
		List<Badcord> badlist = badCordSerDao.findcri(bad,p.getPage(),p.getRows());
		map.put("rows", badlist);
		map.put("total", badCordSerDao.getTotal(bad));
		return map;
	}
	
	/**************************BADCORD****************************/
	/**
	 * 
	*Description:<p style="color:red"> 根据房间号得到订单信息</p>
	*@param roomid 房间id
	*@return
	 */
	@RequestMapping("/getresinfo.do")
	@ResponseBody
	public Map<String, Object> getresinfo(int roomid){
		Map<String, Object> map= new HashMap<String, Object>();
		Room room =roomSerDao.get(Room.class, roomid);
		Reserve res1=new Reserve();
		res1.setRoomnum(room.getRoomnum());
		res1.setResstate("正常");
		Reserve res= resSerDao.find(res1).get(0);
		map.put("res", res);
		return map;
	}
	
}
