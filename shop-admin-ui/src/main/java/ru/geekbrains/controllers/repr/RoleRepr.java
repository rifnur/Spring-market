package ru.geekbrains.controllers.repr;

import ru.geekbrains.persist.model.Role;

import javax.validation.constraints.NotEmpty;

public class RoleRepr {

    private Long id;

    @NotEmpty
    private String name;

    public RoleRepr() {
    }

    public RoleRepr(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleRepr{" +
                "id=" + id +
                ", name='" + name + '\''  +
                '}';
    }
}
