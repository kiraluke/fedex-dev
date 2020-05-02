package com.ascending.service;

import com.ascending.model.Role;
import com.ascending.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role getRoleById(Long Id){ return roleDao.getRoleById(Id); }
    public Role saveRole(Role role){return roleDao.save(role); }
    public Role getRoleByUsername(String username){return roleDao.getRoleByUsername(username);}
}
