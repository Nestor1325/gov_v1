package com.gov.repository;

import com.gov.storage.StorageManager;
import com.gov.model.User;

import java.util.List;

public class UserRepository {

  private StorageManager storageManager;
  private List<User> listUsers;

  public UserRepository() {

    storageManager = StorageManager.getInstance();
    listUsers = storageManager.cargarUsuario();
    addAdminUser();
  }

  private void saveUsers() {
    storageManager.guardarUsuario(listUsers);
  }

  public void add(String name, String pass) {

    listUsers.add(new User(name, pass));

    saveUsers();
  }

  public void add(String name, String pass, boolean isAdmin) {

    listUsers.add(new User(name, pass, isAdmin));

    saveUsers();
  }

  public User findByUserName(String userName) {

    for (User u : listUsers) {
      if (u.getName().equals(userName)) {
        // System.out.println("usuario encontrado");
        return u;
      }
    }

    return null;
  }

  private void addAdminUser() {
    if (findByUserName("admin") == null) {
      add("admin", "123", true);
    }
  }

  public List<User> getListUsers() {
    return listUsers;
  }
}
