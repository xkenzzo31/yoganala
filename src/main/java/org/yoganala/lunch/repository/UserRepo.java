package org.yoganala.lunch.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.yoganala.lunch.entity.User;

public interface UserRepo extends CrudRepository<User,String> {
    @Query(value="SELECT * FROM user WHERE email = ?1", nativeQuery=true)
    public User selectUsers(String email);
}
