package com.gsh.service; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.model.Balance;

/** 
 * @author gdd
 * @version time：2017-1-6 上午4:40:23 
 * 类说明 
 */
@Transactional
@Service("balSerDao")
public class BalSerDaoImpl extends BaseSerDaoImpl<Balance> implements BalSerDao {

}
 