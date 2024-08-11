package com.example.demospring.relationship.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id")
//    @JsonIgnore
    private Passport passport;
}
