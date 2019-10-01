package org.yoganala.lunch.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.yoganala.lunch.entity.Role;

import javax.transaction.Transactional;

public interface RoleRepo extends CrudRepository<Role,String> {
    @Query(value = "insert into user_role (user_user_email,role_role_name)value (?1, ?2)",nativeQuery = true)
    @Transactional
    @Modifying
    public void pushRole(String email,  String role);
}
