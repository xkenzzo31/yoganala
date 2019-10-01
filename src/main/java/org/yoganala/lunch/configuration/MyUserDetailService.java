package org.yoganala.lunch.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.yoganala.lunch.entity.User;
import org.yoganala.lunch.repository.UserRepo;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.selectUsers(username);
        if(user == null){
            throw new UsernameNotFoundException("User Name "+username +"Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),passwordEncoder().encode(user.getPassword()),getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(User user){

        Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
        if(user.getRole().contains("ADMIN")){
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthority;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
