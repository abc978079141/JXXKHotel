package com.gsh.dao;

import java.util.List;
import java.util.Map;

import com.gsh.base.BaseDAO;
import com.gsh.model.PageInfo;
import com.gsh.model.Room;

public interface RoomDao extends BaseDAO<Room>{
	public List<Room> searchbymap(Map<String ,Integer> r,PageInfo p);
}
