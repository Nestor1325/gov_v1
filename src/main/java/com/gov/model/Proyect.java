package com.gov.model;

public class Proyect {

  private String nombre, descripcion, empresa, ubicacion, estado;
  private int presupuesto;

  public Proyect(
      String nombre,
      String descripcion,
      String empresa,
      String ubicacion,
      String estado,
      int presupuesto) {

    this.nombre = nombre;
    this.descripcion = descripcion;
    this.empresa = empresa;
    this.ubicacion = ubicacion;
    this.estado = estado;
    this.presupuesto = presupuesto;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public void setPreuspuesto(int presupuesto) {
    this.presupuesto = presupuesto;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getEmpresa() {
    return empresa;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public String getEstado() {
    return estado;
  }

  public int getPreuspuesto() {
    return presupuesto;
  }
}
