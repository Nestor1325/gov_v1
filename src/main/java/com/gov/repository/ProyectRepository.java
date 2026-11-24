package com.gov.repository;

import com.gov.storage.StorageManager;
import com.gov.model.Proyect;

import java.util.List;

public class ProyectRepository {

  private StorageManager storageManager;
  private List<Proyect> listProyects;

  public ProyectRepository() {

    storageManager = StorageManager.getInstance();
    listProyects = storageManager.cargarProyecto();

    // add("nombre", "desc", "empr", "ubic", "estd", 300);
    // add("nombre", "desc", "empr", "ubic", "estd", 300);
    // add("nombre", "desc", "empr", "ubic", "estd", 300);
    // add("nombre", "desc", "empr", "ubic", "estd", 300);
    // add("nombre", "desc", "empr", "ubic", "estd", 300);
    // add("nombre", "desc", "empr", "ubic", "estd", 300);
    // add("nombre", "desc", "empr", "ubic", "estd", 300);
  }

  private void saveProyects() {
    storageManager.guardarProyecto(listProyects);
  }

  public void add(String nombre, String desc, String empr, String ubic, String estd, int pres) {
    listProyects.add(new Proyect(nombre, desc, empr, ubic, estd, pres));
    saveProyects();
  }

  public List<Proyect> getListProyects() {
    return listProyects;
  }
}
