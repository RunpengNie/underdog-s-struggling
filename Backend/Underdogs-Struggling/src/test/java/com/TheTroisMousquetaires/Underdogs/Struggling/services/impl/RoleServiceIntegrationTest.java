package com.TheTroisMousquetaires.Underdogs.Struggling.services.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RoleServiceIntegrationTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindRoleById() {

        // Retrieve the role from the database
        Optional<Role> retrievedRole = roleService.findRoleById(0);

        // Assertions
        assertTrue(retrievedRole.isPresent(), "Role not found in the database");
        assertEquals(0, retrievedRole.get().getRoleID(), "Incorrect role ID");
        assertEquals("test", retrievedRole.get().getRoleName(), "Incorrect role name");
    }
}
