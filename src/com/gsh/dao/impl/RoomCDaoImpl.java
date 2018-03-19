package com.gsh.dao.impl;


import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.RoomCDao;
import com.gsh.model.RoomConList;
@Transactional
@Repository("RoomConDao")
public class RoomCDaoImpl extends BaseDAOImpl<RoomConList> implements RoomCDao {

}
