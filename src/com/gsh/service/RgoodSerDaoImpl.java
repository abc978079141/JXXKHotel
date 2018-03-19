package com.gsh.service; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.model.Rgood;

/** 
 * @author gdd
 * @version time：2017-1-6 上午1:29:05 
 * 类说明 
 */
@Transactional
@Service("rgoodSerDao")
public class RgoodSerDaoImpl extends BaseSerDaoImpl<Rgood> implements RgoodSerDao {
	
	
}
 