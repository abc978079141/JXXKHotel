package com.gsh.service; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.model.Goods;

/** 
 * @author gdd
 * @version time：2017-1-4 下午8:46:36 
 * 类说明 
 */
@Transactional
@Service("goodSerDao")
public class GoodSerDaoImpl extends BaseSerDaoImpl<Goods> implements GoodSerDao{

}
 