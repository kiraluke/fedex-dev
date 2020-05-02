package com.ascending.repository;

import com.ascending.model.Role;

public interface RoleDao {
    Role getRoleById(Long id);
    Role save(Role role);
    Role getRoleByUsername(String username);
}
