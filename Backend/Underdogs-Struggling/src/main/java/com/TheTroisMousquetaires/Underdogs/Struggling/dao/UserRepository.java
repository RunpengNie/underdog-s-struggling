package com.TheTroisMousquetaires.Underdogs.Struggling.dao;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User entity);

    void deleteUserByUserID(long id);

    Optional<User> findUserByUserID(long id);

    List<User> findUsersByUserName(String name);

    Optional<User> findUserByEmail(String email);

    boolean existsUserByUserID(long id);
}
