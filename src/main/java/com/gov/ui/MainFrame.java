package com.gov.ui;

import com.gov.ui.panel.main.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * MainFrame
 */
public class MainFrame extends JFrame {

  private MainPanel mainPanel;

  public MainFrame(String name) {
    super(name);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new FlowLayout(FlowLayout.CENTER));

    mainPanel = new MainPanel(this);

    add(mainPanel);
  }
}
