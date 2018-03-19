package com.gsh.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.HotelMem;
@Transactional
@Service("hotelMemSerDao")
public class HotelMemSerDaoImpl extends BaseSerDaoImpl<HotelMem> implements
		HotelMemSerDao {

}
