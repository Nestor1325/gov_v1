package com.gov.ui.panel.main.registro;

import com.gov.service.ProyectService;
import com.gov.ui.Dialogs;

import javax.swing.*;
import java.awt.*;

public class ProyectFormPanel extends JPanel {

  private ProyectService proyectService;
  private JLabel nombreLabel, empresaLabel, descripcionLabel;
  private JLabel ubicacionJLabel, estadoLabel, presupuestoLabel;
  private JTextArea descripcionTextArea;
  private JScrollPane scrollDescription;
  private JTextField nombreInput, empresaInput, ubicacionInput, presupuestoInput;

  private JRadioButton rBtnActivo;
  private JRadioButton rBtnPausado;
  private JRadioButton rBtnPendiente;
  private JPanel estadoPanel;

  private JPanel tableFormPanel;
  private GridBagConstraints gbc;
  private JButton acceptBtn;

  public ProyectFormPanel(ProyectService proyectService) {

    this.proyectService = proyectService;

    setLayout(new FlowLayout(FlowLayout.CENTER));

    setFormPanel();

    addElements();
  }

  private void setFormPanel() {

    setEstadoInput();
    setDescriptionInput();

    nombreLabel = new JLabel("nombre del proyecto");
    empresaLabel = new JLabel("empresa encargada");
    descripcionLabel = new JLabel("descripcion");
    ubicacionJLabel = new JLabel("ubicacion");
    estadoLabel = new JLabel("estado actual");
    presupuestoLabel = new JLabel("presupuesto destinado (Bs.)");

    Dimension inputDimension = new Dimension(250, 30);

    nombreInput = new JTextField();
    nombreInput.setPreferredSize(inputDimension);
    empresaInput = new JTextField();
    empresaInput.setPreferredSize(inputDimension);
    ubicacionInput = new JTextField();
    ubicacionInput.setPreferredSize(inputDimension);
    presupuestoInput = new JTextField();
    presupuestoInput.setPreferredSize(inputDimension);

    // tableFormPanel = new JPanel(new GridLayout(12, 0, 3, 3));
    tableFormPanel = new JPanel(new GridBagLayout());
    gbc = new GridBagConstraints();

    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.BOTH;

    setgbc(0, 0);
    tableFormPanel.add(nombreLabel, gbc);
    setgbc(0, 1);
    tableFormPanel.add(nombreInput, gbc);
    setgbc(1, 0);
    tableFormPanel.add(empresaLabel, gbc);
    setgbc(1, 1);
    tableFormPanel.add(empresaInput, gbc);

    setgbc(0, 2);
    tableFormPanel.add(ubicacionJLabel, gbc);
    setgbc(0, 3);
    tableFormPanel.add(ubicacionInput, gbc);
    setgbc(1, 2);
    tableFormPanel.add(presupuestoLabel, gbc);
    setgbc(1, 3);
    tableFormPanel.add(presupuestoInput, gbc);

    setgbc(0, 4);
    tableFormPanel.add(estadoLabel, gbc);
    setgbc(0, 5);
    tableFormPanel.add(estadoPanel, gbc);
    setgbc(1, 4);
    tableFormPanel.add(descripcionLabel, gbc);
    setgbc(1, 5);
    gbc.gridwidth = 1;
    gbc.gridheight = 2;
    tableFormPanel.add(scrollDescription, gbc);

    setAcceptBtn();

    setgbc(0, 7);
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    tableFormPanel.add(acceptBtn, gbc);
  }

  private void setgbc(int gridx, int gridy) {
    gbc.gridx = gridx;
    gbc.gridy = gridy;
  }

  private void setEstadoInput() {

    rBtnActivo = new JRadioButton("activo");
    rBtnPausado = new JRadioButton("pausado");
    rBtnPendiente = new JRadioButton("pendiente");

    ButtonGroup group = new ButtonGroup();

    group.add(rBtnActivo);
    group.add(rBtnPausado);
    group.add(rBtnPendiente);

    estadoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    estadoPanel.add(rBtnActivo);
    estadoPanel.add(rBtnPausado);
    estadoPanel.add(rBtnPendiente);
  }

  private void setDescriptionInput() {

    descripcionTextArea = new JTextArea();
    scrollDescription = new JScrollPane(descripcionTextArea);
    scrollDescription.setPreferredSize(new Dimension(250, 100));
  }

  private void setAcceptBtn() {

    acceptBtn = new JButton("aceptar");

    acceptBtn.addActionListener(e -> {

      String nom = nombreInput.getText();
      String emp = empresaInput.getText();
      String ubic = ubicacionInput.getText();
      String desc = descripcionTextArea.getText();

      String estado = getEstado();

      int pres = Integer.parseInt(presupuestoInput.getText());

      /*
       * boolean validate = true;
       * if (nom.trim().isEmpty() && validate) {
       * Dialogs.showError(null, "");
       * validate = false;
       * }
       * if (emp.trim().isEmpty() && validate) {
       * Dialogs.showError(null, "");
       * validate = false;
       * }
       * if (ubic.trim().isEmpty() && validate) {
       * Dialogs.showError(null, "");
       * validate = false;
       * }
       * if (desc.trim().isEmpty() && validate) {
       * Dialogs.showError(null, "");
       * validate = false;
       * }
       * if (estado.trim().isEmpty() && validate) {
       * Dialogs.showError(null, "");
       * validate = false;
       * }
       */

      if (Dialogs.showDialog(null, "Quiere continuar ???")) {
        if (proyectService.add(nom, desc, emp, ubic, estado, pres)) {
          Dialogs.showInfo(null, "registro completado exitosamente");
        } else {
          Dialogs.showError(null, "Error de formato o campos vacios, \npor favor intentar de nuevo");
        }
      }
    });
  }

  private String getEstado() {

    if (rBtnActivo.isSelected())
      return "activo";

    if (rBtnPausado.isSelected())
      return "pausado";

    if (rBtnPendiente.isSelected())
      return "pendiente";

    return "";
  }

  private void addElements() {

    add(tableFormPanel);
  }
}
