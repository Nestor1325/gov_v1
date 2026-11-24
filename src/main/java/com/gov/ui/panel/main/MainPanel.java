package com.gov.ui.panel.main;

import com.gov.ui.panel.shared.HeaderPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

  private HeaderPanel header;
  private TaskPanel taskPanel;

  public MainPanel(JFrame mainFrame) {

    setLayout(new BorderLayout());

    header = new HeaderPanel(mainFrame);
    taskPanel = new TaskPanel();

    add(header, BorderLayout.NORTH);
    add(taskPanel, BorderLayout.CENTER);
  }
}
