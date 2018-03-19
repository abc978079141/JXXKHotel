package com.gsh.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsh.dao.RoomDao;
import com.gsh.model.PageInfo;
import com.gsh.model.Room;
@Service("roomSerDao")
public class RoomSerDaoImpl  extends BaseSerDaoImpl<Room> implements RoomSerDao {
	private RoomDao roomDao;
	@Resource
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	public List<Room> searchbymap(Map<String, Integer> r,PageInfo p){
		return roomDao.searchbymap(r,p);
	}

}
