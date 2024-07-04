package com.example.jpastart2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String id;
    private String password;
    private String name;
    private String addr;

}
