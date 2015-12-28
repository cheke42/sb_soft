package net.sbit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sbit.hibernate.PersistirVentana;
import net.sbit.window.Ventana;

@SuppressWarnings("restriction")
public class ControladorVentana {

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
	if (PersistirVentana.existeVentana(fieldNombre.getText())) {
	    System.out.println("LA VENTANA YA EXISTE");
	} else {
	    PersistirVentana.nuevo(fieldNombre.getText());
	}
	salir(null);
    }

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

}
