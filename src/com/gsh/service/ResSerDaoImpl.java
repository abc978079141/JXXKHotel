package com.gsh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.dao.ReserveDao;
import com.gsh.model.Reserve;
/**
 * 
*<p>Title:ResSerDaoImpl </p>
*<p style="color:red;">Description:订单管理扩展实现类 </p>
*<p>Company: jxxkhotel </p> 
*@author gdd
*@date 2016-12-30 下午4:26:10
 */
@Transactional
@Service("resSerDao")
public class ResSerDaoImpl  extends BaseSerDaoImpl<Reserve> implements ResSerDao {
	private ReserveDao reserveDao;
	@Resource
	public void setReserveDao(ReserveDao reserveDao) {
		this.reserveDao = reserveDao;
	}
	

}
