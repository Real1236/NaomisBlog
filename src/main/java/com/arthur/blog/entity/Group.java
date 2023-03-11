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

    public Group() {
    }

    public Group(int id, String code, String name, Set<UserEntity> userEntities) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.userEntities = userEntities;
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

    public Set<UserEntity> getUsers() {
        return userEntities;
    }

    public void setUsers(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
