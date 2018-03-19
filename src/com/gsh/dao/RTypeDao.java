package com.gsh.dao; 

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gsh.base.BaseDAO;
import com.gsh.model.RoomType;

/** 
 * @author gdd
 * @version time：2017-1-5 上午1:06:50 
 * 类说明 
 */
@Transactional
@Repository("rtDao")
public interface RTypeDao extends BaseDAO<RoomType> {

}
 