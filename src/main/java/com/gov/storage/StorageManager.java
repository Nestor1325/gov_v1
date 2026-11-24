package com.gov.storage;

import com.gov.model.User;
import com.gov.model.Proyect;

import java.util.List;

public class StorageManager {

  private static final String ARCHIVE_USERS = "users.dat";
  private static final String ARCHIVE_PROYECTS = "projects.dat";

  private UserStorage userStorage;
  private ProyectStorage proyectStorage;

  private static StorageManager instance;

  private StorageManager() {
    userStorage = new UserStorage(ARCHIVE_USERS);
    proyectStorage = new ProyectStorage(ARCHIVE_PROYECTS);
  }

  public static StorageManager getInstance() {
    if (instance == null) {
      instance = new StorageManager();
      return instance;
    } else {
      return instance;
    }
  }

  public void guardarUsuario(List<User> listaUsuarios) {
    userStorage.guardar(listaUsuarios);
  }

  public List<User> cargarUsuario() {
    return userStorage.cargar();
  }

  public void guardarProyecto(List<Proyect> listaProyectos) {
    proyectStorage.guardar(listaProyectos);
  }

  public List<Proyect> cargarProyecto() {
    return proyectStorage.cargar();
  }
}
