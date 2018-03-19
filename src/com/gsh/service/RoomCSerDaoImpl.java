package com.gsh.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.RoomConList;
@Transactional
@Service("RoomCSerDao")
public class RoomCSerDaoImpl extends BaseSerDaoImpl<RoomConList> implements RoomCSerDao {
	
}
