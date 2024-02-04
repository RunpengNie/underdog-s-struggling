package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findRoleById(int roleId);

    Role addRole(Role role);

    void deleteRole(int roleId);
}
