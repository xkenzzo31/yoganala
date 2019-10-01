package org.yoganala.lunch.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//JPA - DB Mapping
@Entity
@Table(name = "user")
public class User implements Serializable, UserDetails {
    @Id
    @Column(name = "USER_EMAIL",unique=true,columnDefinition="VARCHAR(64)")
    private String email;
    private String password;
    private Boolean actived;
    @ManyToMany
    @JoinTable(name = "USER_ROLE")
    private Collection<Role> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
