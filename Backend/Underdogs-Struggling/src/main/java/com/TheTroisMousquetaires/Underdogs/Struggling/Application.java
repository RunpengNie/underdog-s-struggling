package com.TheTroisMousquetaires.Underdogs.Struggling;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.RoleRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(RoleRepository repository) {
		return args -> {

			Role role = new Role();
			role.setRoleName("TestRole");

			repository.save(role);
			Optional<Role> saved = repository.findRoleByRoleID(role.getRoleID());
		};
    }
}
