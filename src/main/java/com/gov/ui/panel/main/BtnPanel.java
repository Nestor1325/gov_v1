package com.gov.ui.panel.main;

import com.gov.config.SessionManager;

import javax.swing.*;
import java.awt.*;

public class BtnPanel extends JPanel {

  private JPanel mainPanel;

  private JButton signUpBtn;
  private JButton proyectFormBtn;
  private JButton proyectsBtn;
  private JButton usersBtn;

  public BtnPanel(JPanel mainPanel) {
    this.mainPanel = mainPanel;

    setLayout(new FlowLayout(FlowLayout.CENTER));

    usersBtn = new JButton("gestionar usarios");
    signUpBtn = new JButton("registar nuevo usuario");
    proyectsBtn = new JButton("gestionar proyectos");
    proyectFormBtn = new JButton("registrar proyecto");

    setActionBtn();

    addElements();
  }

  private void setActionBtn() {

    CardLayout card = (CardLayout) mainPanel.getLayout();

    usersBtn.addActionListener(e -> {
      card.show(mainPanel, "usersPanel");
    });

    signUpBtn.addActionListener(e -> {
      card.show(mainPanel, "signUpPanel");
    });

    proyectsBtn.addActionListener(e -> {
      card.show(mainPanel, "proyectsPanel");
    });

    proyectFormBtn.addActionListener(e -> {
      card.show(mainPanel, "proyectFormPanel");
    });
  }

  private void addElements() {

    if (SessionManager.getCurrentUser().isAdmin()) {
      add(usersBtn);
      add(signUpBtn);
    }

    add(proyectsBtn);
    add(proyectFormBtn);
  }
}
