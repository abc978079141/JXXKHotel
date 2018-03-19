package com.gsh.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.Badcord;
/**
 * 
 *<p>Title:BadCordSerDaoImpl</p>
 *<p>Description:不良记录操作实现类</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-5-15 下午1:49:42
 */
@Service("BadCordSerDao")
@Transactional
public class BadCordSerDaoImpl extends BaseSerDaoImpl<Badcord> implements
		BadCordSerDao {

}
