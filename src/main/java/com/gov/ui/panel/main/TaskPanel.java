package com.gov.ui.panel.main;

import com.gov.service.AuthService;
import com.gov.service.ProyectService;
import com.gov.ui.panel.main.view.UsersPanel;
import com.gov.ui.panel.main.view.ProyectsPanel;
import com.gov.ui.panel.main.registro.ProyectFormPanel;
import com.gov.ui.panel.main.registro.SignUpPanel;

import javax.swing.*;
import java.awt.*;

// @SuppressWarnings("unused")
public class TaskPanel extends JPanel {

  private BtnPanel btnPanel;
  private CardLayout cardLayout;
  private JPanel container;

  private UsersPanel usersPanel;
  private ProyectsPanel proyectsPanel;
  private ProyectFormPanel proyectFormPanel;
  private SignUpPanel signUpPanel;

  private AuthService authService;
  private ProyectService proyectService;

  public TaskPanel() {

    setLayout(new BorderLayout());

    authService = new AuthService();
    proyectService = new ProyectService();

    cardLayout = new CardLayout();
    container = new JPanel(cardLayout);
    btnPanel = new BtnPanel(container);

    usersPanel = new UsersPanel(authService);
    proyectsPanel = new ProyectsPanel(proyectService);
    proyectFormPanel = new ProyectFormPanel(proyectService);
    signUpPanel = new SignUpPanel(authService);

    container.add(proyectsPanel, "proyectsPanel");
    container.add(usersPanel, "usersPanel");
    container.add(proyectFormPanel, "proyectFormPanel");
    container.add(signUpPanel, "signUpPanel");

    add(btnPanel, BorderLayout.NORTH);
    add(container, BorderLayout.CENTER);
  }
}
