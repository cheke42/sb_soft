package net.sbit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sbit.hibernate.PersistirComponente;
import net.sbit.window.Ventana;

@SuppressWarnings("restriction")
public class ControladorComponente {
    private Ventana ventana;

    @FXML
    private TextField fieldNombre;

    @FXML
    private Button buttonGuardar;

    @FXML
    private Button buttonSalir;

    @FXML
    private Label labelNombre;

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    @FXML
    void guardar(ActionEvent event) {
	if (PersistirComponente.existeComponente(fieldNombre.getText())) {
	    System.out.println("EL PERMISO YA EXISTE!");
	} else {
	    PersistirComponente.nuevo(fieldNombre.getText());
	    salir();
	}

    }

    @FXML
    void salir() {
	ventana.getEscenario().close();
    }

}
