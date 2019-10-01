package org.yoganala.lunch.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @Column(name = "ROLE_NAME",unique=true,columnDefinition="VARCHAR(64)")
    private String roleName;
    private String descrition;
}
