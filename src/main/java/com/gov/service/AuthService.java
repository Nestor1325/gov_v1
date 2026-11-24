package com.gov.service;

import com.gov.model.User;
import com.gov.repository.UserRepository;

import java.util.List;

import com.gov.config.SessionManager;

public class AuthService {

  private UserRepository userRepository;

  public AuthService() {

    userRepository = new UserRepository();
  }

  public boolean validate(String name, String pass) {

    User user = userRepository.findByUserName(name);

    if (user != null) {
      // System.out.println("Objeto usario no encontrado");
      if (user.getPassword().equals(pass)) {
        SessionManager.setCurrentUser(user);
        return true;
      } else {
        // System.out.println("contraseña incorrecta");
      }
    }

    return false;
  }

  public boolean addNewUser(String name, String pass, boolean isAdmin) {

    boolean validateFormat = validateUserNameFormat(name) && validatePasswordFormat(pass);

    if (userRepository.findByUserName(name) == null && validateFormat) {
      userRepository.add(name, pass, isAdmin);
      return true;
    } else {
      return false;
    }
  }

  // validaciones internas

  private boolean validatePasswordFormat(String pass) {

    int contInt = 0;
    for (int i = 0; i < pass.length(); i++) {
      if (Character.isDigit(pass.charAt(i))) {
        contInt++;
      }

    }

    if (contInt >= 3 && pass.length() >= 8) {
      return true;
    } else {
      return false;
    }
  }

  private boolean validateUserNameFormat(String name) {
    if (name.length() >= 8) {
      return true;
    } else {
      return false;
    }
  }

  public List<User> getListUsers() {
    return userRepository.getListUsers();
  }
}
