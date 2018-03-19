package com.gsh.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.MemTypeDao;
import com.gsh.model.MemType;
@Repository("memTypeDao")
@Transactional
public class MemTypeDaoImpl extends BaseDAOImpl<MemType> implements MemTypeDao {

}
