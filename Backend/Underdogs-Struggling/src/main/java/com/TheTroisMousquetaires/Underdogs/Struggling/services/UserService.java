package com.TheTroisMousquetaires.Underdogs.Struggling.services;

import com.TheTroisMousquetaires.Underdogs.Struggling.entities.User;

import java.util.Optional;
import java.util.*;

public interface UserService {
    Optional<User> findUserByID(long id);

    Optional<User> findUserByEmail(String email);

    List<User> findUsersByName(String userName);

    User addUser(User u);

    User updateUser(User u, long id);

    void deleteUser(long id);
}
