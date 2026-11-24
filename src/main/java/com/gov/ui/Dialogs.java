package com.gov.ui;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Dialogs {

  public static void showInfo(JFrame parent, String message) {

    JOptionPane.showMessageDialog(parent, message, "Info", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showError(JFrame parent, String message) {

    JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  // revizar antes de usar

  public static boolean showDialog(JFrame parent, String message) {

    int resultado = JOptionPane.showConfirmDialog(
        parent,
        message,
        "Confirmar Accion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);

    return resultado == JOptionPane.YES_OPTION;
  }
}
