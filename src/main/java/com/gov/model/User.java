package com.gov.model;

public class User {

  private String name;
  private String password;
  private boolean isAdmin;

  public User(String name, String password) {

    this.name = name;
    this.password = password;
    this.isAdmin = false;
  }

  public User(String name, String password, boolean isAdmin) {

    this.name = name;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  @Override
  public String toString() {
    return "User{name:" + this.name + ",password:" + this.password + "}";
  }
}
