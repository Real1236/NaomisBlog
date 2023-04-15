package com.arthur.blog.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ad_groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "group_code")
    private String code;

    @Column(name = "group_name")
    private String name;

    @ManyToMany(mappedBy = "userGroups")
    private Set<UserEntity> userEntities;

    public void addUser(UserEntity user){
        userEntities.add(user);
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
