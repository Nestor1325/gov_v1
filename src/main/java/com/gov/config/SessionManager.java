package com.gov.config;

import com.gov.model.User;

public class SessionManager {

  private static User currentUser;

  public static void setCurrentUser(User user) {
    currentUser = user;
  }

  public static User getCurrentUser() {
    return currentUser;
  }

  public static void logOut() {
    currentUser = null;
  }

  public static boolean isAdmin() {
    if (currentUser != null) {
      return currentUser.isAdmin();
    }
    return false;
  }
}
