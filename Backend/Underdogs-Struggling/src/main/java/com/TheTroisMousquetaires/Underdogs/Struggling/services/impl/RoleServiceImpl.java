package com.TheTroisMousquetaires.Underdogs.Struggling.services.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.RoleRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findRoleByID(int roleID) {
        return roleRepository.findRoleByRoleID(roleID);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRoleByRoleId(int roleID) {
        roleRepository.deleteRoleByRoleID(roleID);
    }
}
