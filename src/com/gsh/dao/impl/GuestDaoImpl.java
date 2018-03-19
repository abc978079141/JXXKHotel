package com.gsh.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.GuestDao;
import com.gsh.model.Guest;
@Transactional
@Repository("guestDao")
public class GuestDaoImpl extends BaseDAOImpl<Guest> implements GuestDao {

}
