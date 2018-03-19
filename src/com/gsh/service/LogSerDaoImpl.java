package com.gsh.service;

import javax.transaction.Transactional;
import com.gsh.service.BaseSerDaoImpl;
import org.springframework.stereotype.Service;

import com.gsh.model.Log;
/**
 * 
 *<p>Title:LogSerDaoImpl</p>
 *<p>Description:日志操作服务层实现类</p>
 *<p>Company:GSH</p>
 * @author gdd
 * @date:2017-5-15 下午5:24:04
 */
@Service("logService")
@Transactional
public class LogSerDaoImpl extends BaseSerDaoImpl<Log> implements LogSerDao {

}
