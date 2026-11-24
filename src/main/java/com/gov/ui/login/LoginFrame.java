package com.gov.ui.login;

import com.gov.service.AuthService;
import com.gov.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame implements SignInPanel.SignInPanelListener {

  private SignInPanel signInPanel;
  private AuthService authService;

  public LoginFrame(String ventana) {
    super(ventana);

    setLayout(new FlowLayout(FlowLayout.CENTER));

    authService = new AuthService();

    signInPanel = new SignInPanel(authService, this);

    add(signInPanel);
  }

  @Override
  public void toMain() {
    new MainFrame("ventana").setVisible(true);
    this.dispose();
  }
}
