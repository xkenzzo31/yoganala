package org.yoganala.lunch.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//JPA - DB Mapping
@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @Column(name = "contenue", length = 10000)
    private String contenue;
    private String image;
}
