package com.gov.ui.panel.main.view;

import com.gov.service.ProyectService;
import com.gov.model.Proyect;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProyectsPanel extends JPanel {

  private JTable tableUsers;
  private DefaultTableModel model;
  private JScrollPane scrollPane;
  private ProyectService proyectService;
  private List<Proyect> listProyects;

  public ProyectsPanel(ProyectService proyectService) {

    setLayout(new FlowLayout(FlowLayout.CENTER));

    this.proyectService = proyectService;

    setTable();
    addElements();
  }

  private void setTable() {

    String[] filas = { "nombre", "empresa", "ubicacion", "estado", "presupuesto" };

    listProyects = proyectService.getListProyects();

    model = new DefaultTableModel(filas, 0);

    for (Proyect p : listProyects) {

      String nom = p.getNombre();
      String emp = p.getEmpresa();
      String ubic = p.getUbicacion();
      String est = p.getEstado();
      float pres = p.getPreuspuesto();

      Object[] row = { nom, emp, ubic, est, pres };

      model.addRow(row);
    }

    tableUsers = new JTable(model);
    scrollPane = new JScrollPane(tableUsers);
    scrollPane.setPreferredSize(new Dimension(400, 300));
  }

  private void addElements() {

    add(scrollPane);
  }
}
