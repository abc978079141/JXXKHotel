package com.gsh.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.HotelUserDao;
import com.gsh.model.HotelUser;
@Transactional
@Repository("hotelUserDao")
public class HotelUserDaoImpl  extends BaseDAOImpl<HotelUser> implements HotelUserDao {
	
}
