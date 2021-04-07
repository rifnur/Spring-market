package ru.geekbrains.info;

import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.model.User;

import java.util.List;

public class UserInfo
{

    public Long id;
    public String password;
    public List<Role> roles;


    public UserInfo(User user)
    {
        id = user.getId();
        password = user.getPassword();

    }


    public UserInfo()
    {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}