package com.gsh.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.RoomDao;
import com.gsh.model.PageInfo;
import com.gsh.model.Room;
@Repository("roomDao")
public class RoomDaoImpl extends BaseDAOImpl<Room> implements RoomDao {

	public List<Room> searchbymap(Map<String, Integer> r,PageInfo p) {
		List<Room> rlist=new ArrayList<Room>();
		String hql = " from Room as r where 1=1 ";
		Set<Entry<String, Integer>> set = r.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Map.Entry<String, Integer> me = (Map.Entry<String, Integer>) io.next();
			if("floor".equals(me.getKey()) && 0!=me.getValue()){
				hql += " and r." + me.getKey() + " ="+ me.getValue();
			}
			if("roomstate".equals(me.getKey()) && 0!=me.getValue()){
				hql += " and r." + me.getKey() + " = " + me.getValue();
			}
			if("roomType.id".equals(me.getKey()) && 0!=me.getValue()){
				hql += " and r." + me.getKey() + " =" + me.getValue();
			}
		}	
		hql+="limit("+(p.getPage()-1)*p.getRows()+","+p.getRows()+")";
		return super.find(hql);
	}
	
	
	

}
