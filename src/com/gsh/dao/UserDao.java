package com.gsh.dao;

import java.util.List;
import com.gsh.base.BaseDAO;
import com.gsh.model.User;


public interface UserDao extends BaseDAO<User> {
	List<User> searchByName(String q) throws Exception;
}
