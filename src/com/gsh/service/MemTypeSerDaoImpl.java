package com.gsh.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.MemType;
@Service("memTypeSerDao")
@Transactional
public class MemTypeSerDaoImpl extends BaseSerDaoImpl<MemType> implements MemTypeSerDao {
}
