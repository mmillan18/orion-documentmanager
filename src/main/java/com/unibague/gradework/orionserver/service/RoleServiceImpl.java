package com.unibague.gradework.orionserver.service;
import com.unibague.gradework.orionserver.model.Role;
import com.unibague.gradework.orionserver.repository.RoleRepository;
import com.unibague.gradework.orionserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(String id) {
        return roleRepository.findById(Long.valueOf(id));
    }

    @Override
    public Optional<Role> updateRole(String id, Role roleDetails) {
        return roleRepository.findById(Long.valueOf(id)).map(existingRole -> {
            existingRole.setName(roleDetails.getName());
            return roleRepository.save(existingRole);
        });
    }

    @Override
    public void deleteRole(String id) {
        roleRepository.deleteById(Long.valueOf(id));
    }
}
