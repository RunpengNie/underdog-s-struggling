package com.TheTroisMousquetaires.Underdogs.Struggling.security;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.UserRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Role;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService{

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDetails> loadUsersByUsername(String username) throws UsernameNotFoundException {

        List<User> users = userRepository.findUsersByUserName(username);
        if(users.isEmpty()){
            throw new UsernameNotFoundException("No user found");
        }

        List<UserDetails> res = new ArrayList<>();

        for(User user : users){

            Role r = user.getRole();
            GrantedAuthority authority = new SimpleGrantedAuthority(r.getRoleName());
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(authority);

            UserDetails curUserDetails = new org.springframework.security.core.userdetails.User(
                    username,
                    user.getPassword(),
                    authorities
            );
            res.add(curUserDetails);
        }
        return res;
    }

    public UserDetails loadUserByEmail(String userEmail) throws UsernameNotFoundException {

        Optional<User> temp = userRepository.findUserByEmail(userEmail);
        if(temp.isEmpty()){
            throw new UsernameNotFoundException("User not exists by Email");
        }
        User user = temp.get();

        Role r = user.getRole();
        GrantedAuthority authority = new SimpleGrantedAuthority(r.getRoleName());
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(authority);

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                authorities
        );
    }
}