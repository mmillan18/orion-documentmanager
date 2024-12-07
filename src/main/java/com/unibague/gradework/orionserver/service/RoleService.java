package com.unibague.gradework.orionserver.service;

import com.unibague.gradework.orionserver.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAllRoles();
    Optional<Role> getRoleById(String id);
    Optional<Role> updateRole(String id, Role roleDetails);
    void deleteRole(String id);
}
