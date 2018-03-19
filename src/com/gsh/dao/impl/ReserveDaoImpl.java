package com.gsh.dao.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.ReserveDao;
import com.gsh.model.Reserve;
/**
 * 
*<p>Title:ReserveDaoImpl </p>
*<p>Description: </p>
*<p>Company: </p> 
*@author gdd
*@date 2016-12-30 下午3:49:12
 */
@Transactional
@Repository("reserDao")
public class ReserveDaoImpl extends BaseDAOImpl<Reserve> implements ReserveDao {	

}
