package com.gov.ui.panel.shared;

import com.gov.ui.Dialogs;
import com.gov.config.SessionManager;
import com.gov.ui.login.LoginFrame;
import com.gov.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * HeaderPanel
 */
public class HeaderPanel extends JPanel {

  private JLabel title;
  private JButton exitBtn;
  private JButton loginBtn, updateBtn;

  public HeaderPanel(JFrame mainFrame) {

    setLayout(new FlowLayout(FlowLayout.CENTER));

    title = new JLabel("Bienvenido " + SessionManager.getCurrentUser().getName());
    exitBtn = new JButton("salir");
    loginBtn = new JButton("cerrar sesion");
    updateBtn = new JButton("actualizar");

    exitBtn.addActionListener(e -> {
      boolean confirmado = Dialogs.showDialog(null, "Seguro que quiere salir ???");
      if (confirmado) {
        mainFrame.dispose();
      }
    });

    loginBtn.addActionListener(e -> {
      boolean confirmado = Dialogs.showDialog(null, "Seguro que quieres cerrar sesion ???");
      if (confirmado) {
        SessionManager.setCurrentUser(null);
        new LoginFrame("iniciar sesion").setVisible(true);
        mainFrame.dispose();
      }
    });

    updateBtn.addActionListener(e -> {
      new MainFrame("Ventana Principal").setVisible(true);
      mainFrame.dispose();
    });

    add(title);
    add(loginBtn);
    add(exitBtn);
    add(updateBtn);
  }
}
