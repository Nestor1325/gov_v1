package com.gov.ui.panel.main.registro;

import com.gov.service.AuthService;
import com.gov.ui.Dialogs;

import javax.swing.*;
import java.awt.*;

public class SignUpPanel extends JPanel {

  private JPanel formPanel;

  private JLabel nameLabel;
  private JLabel passLabel;
  private JTextField nameInput;
  private JTextField passInput;
  private JButton acceptBtn;

  private JCheckBox checkBox;

  private AuthService authService;

  public SignUpPanel(AuthService authService) {

    this.authService = authService;

    addFormPanel();
  }

  private void addFormPanel() {

    JPanel formContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
    formPanel = new JPanel(new GridLayout(6, 1, 3, 3));

    nameLabel = new JLabel("Nombre");
    passLabel = new JLabel("Contraseña");
    nameInput = new JTextField();
    passInput = new JTextField();
    checkBox = new JCheckBox();
    checkBox.setText("dar permisos de administrador ???");
    acceptBtn = new JButton("Aceptar");

    nameInput.setPreferredSize(new Dimension(150, 30));
    passInput.setPreferredSize(new Dimension(150, 30));

    addAcctionAccept();

    formPanel.add(nameLabel);
    formPanel.add(nameInput);
    formPanel.add(passLabel);
    formPanel.add(passInput);
    formPanel.add(acceptBtn);
    formPanel.add(checkBox);

    formContainer.add(formPanel);

    add(formContainer);
  }

  private void addAcctionAccept() {
    acceptBtn.addActionListener(e -> {

      String name = nameInput.getText();
      String pass = passInput.getText();
      boolean isAdmin = checkBox.isSelected();

      nameInput.setText("");
      passInput.setText("");

      boolean accept = false;

      if (isAdmin) {
        accept = Dialogs.showDialog(null, "estas seguro de otorgar permisos de administrador ???");
      } else {
        accept = true;
      }

      if (accept && authService.addNewUser(name, pass, isAdmin)) {
        System.out.println("registro exitoso ...");
        Dialogs.showInfo(null, "registro exitoso ...");
      } else {
        System.out.println("Error de formato, usuario no registrado ...");
        Dialogs.showError(null, "Error de formato, usuario no registrado ...");
      }

    });
  }
}
