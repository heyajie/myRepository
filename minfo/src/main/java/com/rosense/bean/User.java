package com.rosense.bean;

public class User {

    public String name;

    public Integer age;

    public String idid;

    public String role; // role
    public String roleName; // role name

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdid() {
        return idid;
    }

    public void setIdid(String idid) {
        this.idid = idid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
