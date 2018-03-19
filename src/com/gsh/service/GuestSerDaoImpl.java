package com.gsh.service;



import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.Guest;
@Transactional
@Service("guestSerDao")
public class GuestSerDaoImpl  extends BaseSerDaoImpl<Guest> implements GuestSerDao {

	

}
