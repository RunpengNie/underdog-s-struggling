package com.TheTroisMousquetaires.Underdogs.Struggling.service;

import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findRoleByID(int roleID);

    Role addRole(Role role);

    void deleteRoleByRoleId(int roleID);
}
