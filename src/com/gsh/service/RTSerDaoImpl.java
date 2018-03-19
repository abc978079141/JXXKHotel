package com.gsh.service; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.model.RoomType;

/** 
 * @author gdd
 * @version time：2017-1-5 上午1:09:46 
 * 类说明 
 */
@Transactional
@Service("rtSerDao")
public class RTSerDaoImpl extends BaseSerDaoImpl<RoomType> implements RTSerDao {

	

}
 