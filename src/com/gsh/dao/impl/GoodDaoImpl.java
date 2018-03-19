package com.gsh.dao.impl; 

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAOImpl;
import com.gsh.dao.GoodDao;
import com.gsh.model.Goods;

/** 
 * @author gdd
 * @version time：2017-1-4 下午8:45:27 
 * 类说明 
 */
@Transactional
@Repository("goodDao")
public class GoodDaoImpl extends BaseDAOImpl<Goods> implements GoodDao {

}
 