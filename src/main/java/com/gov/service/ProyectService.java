package com.gov.service;

import com.gov.repository.ProyectRepository;
import com.gov.model.Proyect;

import java.util.List;

public class ProyectService {

  private ProyectRepository proyectRepository;

  public ProyectService() {

    proyectRepository = new ProyectRepository();
  }

  public List<Proyect> getListProyects() {

    return proyectRepository.getListProyects();
  }

  public boolean add(String nom, String desc, String empr, String ubic, String estd, int pres) {

    String[] array = { nom, desc, empr, ubic };
    boolean validate = validateStringFormat(array) && validatePresFormat(pres) && validateEstadoFormat(estd);

    if (validate) {
      proyectRepository.add(nom, desc, empr, ubic, estd, pres);
    }

    return validate;
  }

  private boolean validateEstadoFormat(String estado) {

    if (estado == null) {
      return false;
    }

    if (estado.equals("activo"))
      return true;

    if (estado.equals("pausado"))
      return true;

    if (estado.equals("pendiente"))
      return true;

    return false;
  }

  private boolean validateStringFormat(String[] array) {
    for (String s : array) {
      if (!validateStringFormat(s)) {
        return false;
      }
    }
    return true;
  }

  private boolean validateStringFormat(String s) {

    if (s != null && !s.trim().isEmpty() && s.length() >= 5)
      return true;

    return false;
  }

  private boolean validatePresFormat(int pres) {

    if (pres >= 0)
      return true;

    return false;
  }
}
