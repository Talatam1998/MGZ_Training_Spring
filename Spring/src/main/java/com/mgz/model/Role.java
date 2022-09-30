package com.mgz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public Role(String role_admin) {
        this.name = role_admin;
    }

    public Role(Integer id){
        this.id = id;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
