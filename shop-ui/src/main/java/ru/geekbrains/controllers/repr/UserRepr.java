package ru.geekbrains.controllers.repr;

import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.model.User;

import java.util.Set;

public class UserRepr {

    private Long id;
    private String login;
    private String password;
    private Set<Role> roles;

    public UserRepr() {
    }

    public UserRepr(User user)
    {
        id = user.getId();
        password = user.getPassword();
        login = user.getLogin();
        roles = user.getRoles();
    }


}
