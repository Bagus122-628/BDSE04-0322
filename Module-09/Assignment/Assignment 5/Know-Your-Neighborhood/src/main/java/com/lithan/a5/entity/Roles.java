package com.lithan.a5.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Roles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_role")
  private int idRole;

  @Column(name = "role")
  private String role;

  @ManyToMany(mappedBy = "roles")
  private List<Users> users = new ArrayList<>();

  public Roles() {
  }

  public int getIdRole() {
    return idRole;
  }

  public void setIdRole(int idRole) {
    this.idRole = idRole;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public List<Users> getUsers() {
    return users;
  }

  public void setUsers(List<Users> users) {
    this.users = users;
  }

}