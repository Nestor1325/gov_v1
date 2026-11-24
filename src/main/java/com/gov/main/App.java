package com.gov.main;

import com.gov.ui.login.LoginFrame;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LoginFrame("Iniciar sesion").setVisible(true);
        });
    }
}
