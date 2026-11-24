package com.gov.ui.panel.main.view;

import com.gov.service.AuthService;
import com.gov.model.User;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

public class UsersPanel extends JPanel {

  private JTable tableUsers;
  private DefaultTableModel model;
  private JScrollPane scrollPane;
  private AuthService authService;
  private List<User> listUsers;

  public UsersPanel(AuthService authService) {

    setLayout(new FlowLayout(FlowLayout.CENTER));

    this.authService = authService;
    listUsers = this.authService.getListUsers();

    setTable();
    addElements();
  }

  private void setTable() {

    String[] filas = { "nombre", "permisos de administrador" };

    model = new DefaultTableModel(filas, 0);

    for (User u : listUsers) {

      String isAdmin = u.isAdmin() ? "si" : "no";

      Object[] row = { u.getName(), isAdmin };
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
