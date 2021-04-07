package ru.geekbrains.services;


import ru.geekbrains.controllers.repr.UserRepr;
import ru.geekbrains.info.UserInfo;
import ru.geekbrains.persist.model.Role;

import java.util.List;
import java.util.Optional;


public interface UserService
{
  List<UserInfo> findAllUsers();

  Optional<UserInfo> findUserById(Long id);

  Optional<UserInfo> findByUserName(String username);

  boolean save(UserInfo user);

  boolean delete(Long id);

  List<Role> findAllRoles();

}