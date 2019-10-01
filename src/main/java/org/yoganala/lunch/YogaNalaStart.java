package org.yoganala.lunch;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.yoganala.lunch.entity.Role;
import org.yoganala.lunch.entity.User;
import org.yoganala.lunch.repository.RoleRepo;
import org.yoganala.lunch.repository.UserRepo;

@SpringBootApplication
public class YogaNalaStart {

    public static void main(String[] args) {
        ConfigurableApplicationContext apx = SpringApplication.run(YogaNalaStart.class, args);
        UserRepo userRepo = apx.getBean(UserRepo.class);
        RoleRepo roleRepo = apx.getBean(RoleRepo.class);
        User user = new User();
        user.setEmail("paoetla");
        user.setPassword(new BCryptPasswordEncoder().encode("francisetla"));
        user.setActived(true);
        userRepo.save(user);
        Role role = new Role();
        role.setRoleName("ADMIN");
        roleRepo.save(role);
        roleRepo.pushRole(user.getEmail(),role.getRoleName());

        user.setEmail("test");
        user.setPassword(new BCryptPasswordEncoder().encode("test"));
        user.setActived(true);
        userRepo.save(user);
        role.setRoleName("USER");
        roleRepo.save(role);
        roleRepo.pushRole(user.getEmail(),role.getRoleName());
    }
}
