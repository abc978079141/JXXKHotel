package com.gsh.dao.impl; 


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.ConDao;
import com.gsh.model.Consumption;

/** 
 * @author gdd
 * @version time：2017-1-3 下午5:19:10 
 * 类说明 
 */
@Repository("ConDao")
@Transactional
public class ConDaoImpl extends BaseDAOImpl<Consumption> implements ConDao {

	

}
 