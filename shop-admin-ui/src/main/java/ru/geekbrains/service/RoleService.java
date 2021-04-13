package ru.geekbrains.service;

import ru.geekbrains.controllers.repr.RoleRepr;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    void save(RoleRepr roleRepr);

    List<RoleRepr> findAllRole();

    Optional<RoleRepr> findByRoleId(Long id);

    void deleteRole(Long id);
}
