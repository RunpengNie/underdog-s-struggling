package com.TheTroisMousquetaires.Underdogs.Struggling.services.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.RoleRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RoleServiceImplTest {
    @Mock
    private RoleRepository roleRepositoryMock;

    @InjectMocks
    private RoleServiceImpl roleService;

    private Role testRole = new Role();

    @BeforeEach
    void setUp() {
        testRole.setRoleId(0); // Set the appropriate ID
        testRole.setRoleName("Test Role");
        roleService.addRole(testRole);
    }

    @Test
    public void testGetRoleById() {
        // roleService.addRole(testRole);
        // define the behaviors
        Mockito.when(roleRepositoryMock.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.of(testRole));

        // execute
        Optional<Role> response = roleService.findRoleById(0);
        Role result = response.get();

        // assertions
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getRoleID(), 0);
        Assertions.assertEquals(result.getRoleName(), "Test Role");
    }
}


