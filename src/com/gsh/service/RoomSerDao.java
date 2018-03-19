package com.gsh.service;

import java.util.List;
import java.util.Map;

import com.gsh.model.PageInfo;
import com.gsh.model.Room;

public interface RoomSerDao extends BaseSerDao<Room> {
	public List<Room> searchbymap(Map<String ,Integer> r,PageInfo p);
}
