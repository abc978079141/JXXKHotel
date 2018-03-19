package com.gsh.dao.impl; 

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.RecDao;
import com.gsh.model.Recharge;

/** 
 * @author gdd
 * @version time：2017-1-5 下午8:05:37 
 * 类说明 
 */
@Transactional
@Repository("recDao")
public class RecDaoImpl extends BaseDAOImpl<Recharge> implements RecDao {

}
 