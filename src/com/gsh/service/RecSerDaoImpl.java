package com.gsh.service; 

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.gsh.model.Recharge;

/** 
 * @author gdd
 * @version time：2017-1-5 下午8:06:57 
 * 类说明  会员充值
 */
@Transactional
@Service("recSerDao")
public class RecSerDaoImpl extends BaseSerDaoImpl<Recharge> implements
		RecSerDao {

}
 