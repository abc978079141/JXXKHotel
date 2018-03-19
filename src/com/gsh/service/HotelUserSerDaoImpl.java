package com.gsh.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.model.HotelUser;
/**
 * 
*<p>HotelUserSerDaoImpl </p>
*<p style="color:red;">Description:酒店操作扩展实现类 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2017-03-20 下午4:14:27
 */
@Transactional
@Service("hotelUserSerDao")
public class HotelUserSerDaoImpl  extends BaseSerDaoImpl<HotelUser> implements HotelUserSerDao {

}
