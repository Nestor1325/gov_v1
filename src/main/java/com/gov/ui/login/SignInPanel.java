package com.gov.ui.login;

import javax.swing.*;
import java.awt.*;

import com.gov.service.AuthService;
import com.gov.ui.Dialogs;

public class SignInPanel extends JPanel {

  private JTextField nameInput;
  private JTextField passInput;
  private JButton acceptBtn;
  private JLabel nameLabel;
  private JLabel passLabel;

  private AuthService authService;

  public interface SignInPanelListener {

    void toMain();
  }

  SignInPanelListener listener;

  protected SignInPanel(AuthService auth, SignInPanelListener listener) {

    this.listener = listener;

    setLayout(new GridLayout(5, 1, 3, 3));

    this.authService = auth;

    nameInput = new JTextField();
    passInput = new JTextField();
    acceptBtn = new JButton("accept");

    acceptBtn.addActionListener(e -> {

      String name = nameInput.getText();
      String pass = passInput.getText();

      nameInput.setText("");
      passInput.setText("");

      if (authService.validate(name, pass)) {
        listener.toMain();
        Dialogs.showInfo(null, "Usuario encontrado, login exitoso ...");
      } else {
        Dialogs.showError(null, "Usuario no encontrado, login fallido...");
      }
    });

    nameInput.setPreferredSize(new Dimension(150, 30));
    passInput.setPreferredSize(new Dimension(150, 30));

    nameLabel = new JLabel("Nombre:");
    passLabel = new JLabel("Contraseña:");

    add(nameLabel);
    add(nameInput);

    add(passLabel);
    add(passInput);

    add(acceptBtn);
  }
}
