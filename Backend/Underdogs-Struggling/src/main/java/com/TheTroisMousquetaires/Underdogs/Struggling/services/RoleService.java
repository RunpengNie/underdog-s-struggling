package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findRoleByID(int roleID);

    Role addRole(Role role);

    void deleteRole(int roleId);
}
