package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role save(Role entity);

    void deleteRoleById(int id);

    Optional<Role> findRoleByID(int RoleID);

    Optional<Role> findRoleByName(String roleName);

    boolean existsRoleById(int RoleID);
}
