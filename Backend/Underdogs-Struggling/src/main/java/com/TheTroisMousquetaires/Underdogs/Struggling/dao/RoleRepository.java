package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role save(Role entity);

    void deleteRoleByRoleId(int id);

    Optional<Role> findByRoleId(int RoleID);

    Optional<Role> findByRoleName(String roleName);

    boolean existsById(int RoleID);
}
