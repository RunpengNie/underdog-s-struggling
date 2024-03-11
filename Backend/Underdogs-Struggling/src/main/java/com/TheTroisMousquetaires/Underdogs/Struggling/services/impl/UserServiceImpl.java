package com.TheTroisMousquetaires.Underdogs.Struggling.services.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.UserRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entities.User;
import com.TheTroisMousquetaires.Underdogs.Struggling.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserByID(long id){
        return userRepository.findUserByUserID(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findUsersByName(String userName){
        return userRepository.findUsersByUserName(userName);
    }

    @Override
    public User addUser(User u){
        return userRepository.save(u);
    }

    @Override
    public User updateUser(User u, long id){
        return userRepository.save(u);
    }

    @Override
    public void deleteUser(long id){
        userRepository.deleteUserByUserID(id);
    }

}
