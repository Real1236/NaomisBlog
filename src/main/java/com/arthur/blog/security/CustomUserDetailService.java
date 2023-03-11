package com.arthur.blog.security;

import com.arthur.blog.dao.UserRepository;
import com.arthur.blog.entity.Group;
import com.arthur.blog.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity reader = userRepository.findByUsername(username);
        if (reader == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.withUsername(username)
                .password(reader.getPassword())
                .authorities(getAuthorities(reader))
                .build();
    }

    private Collection<GrantedAuthority> getAuthorities(UserEntity user) {
        Set<Group> userGroups = user.getUserGroups();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
        for (Group userGroup : userGroups) {
            authorities.add(new SimpleGrantedAuthority(userGroup.getCode().toUpperCase()));
        }
        return authorities;
    }
}
