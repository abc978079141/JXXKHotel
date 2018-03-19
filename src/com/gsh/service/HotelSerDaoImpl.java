package com.gsh.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.Hotel;
/**
 * 
 *<p>Title:HotelSerDaoImpl</p>
 *<p>Description:</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-5-16 上午11:38:07
 */
@Service("hotelSerDao")
@Transactional
public class HotelSerDaoImpl extends BaseSerDaoImpl<Hotel> implements
		HotelSerDao {
}
