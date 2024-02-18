package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User entity);

    void deleteUserById(long id);

    Optional<User> findUserById(long id);

    List<User> findUsersByName(String name);

    Optional<User> findUserByEmail(String email);

    boolean existsUserById(long id);
}
