package com.gsh.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsh.model.UserRole;
@Transactional
@Service("userRoleSerDao")
public class UserRoleSerDaoImpl extends BaseSerDaoImpl<UserRole> implements UserRoleSerDao {

}
