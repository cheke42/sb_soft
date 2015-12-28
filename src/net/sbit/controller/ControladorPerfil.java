package net.sbit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sbit.hibernate.PersistirPerfil;
import net.sbit.window.Ventana;

@SuppressWarnings("restriction")
public class ControladorPerfil {
    private Ventana ventana;

    @FXML
    private Label labelNombrePerfil;

    @FXML
    private TextField fieldNombrePerfil;

    @FXML
    private Button buttonGuardar;

    @FXML
    private Button buttonSalir;

    @FXML
    private CheckBox checkBoxHabilitado;

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    @FXML
    void guardar(ActionEvent event) {
	if (PersistirPerfil.existePerfil(fieldNombrePerfil.getText())) {
	    System.out.println("EL PERFIL YA EXISTE");
	} else {
	    PersistirPerfil.nuevo(fieldNombrePerfil.getText(), checkBoxHabilitado.isSelected());
	}
	salir(null);
    }

    @FXML
    void habilitado(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

}
