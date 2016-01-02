package net.sbit.controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import net.sbit.hibernate.PersistirPerfil;
import net.sbit.hibernate.PersistirVentana;
import net.sbit.model.Perfil;
import net.sbit.window.Ventana;

public class ControladorAdministracionPermisos {

    private Ventana ventana;

    @FXML
    private Label labelVentana;

    @FXML
    private Label labelPerfil;

    @FXML
    private ComboBox<String> comboPerfil;

    @FXML
    private TableView<?> tableViewPermisos;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnEstado;

    @FXML
    private Button buttonEditarPerfil;

    @FXML
    private TableColumn<?, ?> columnTipo;

    @FXML
    private ImageView imageEditarPerfil;

    @FXML
    private Button buttonGuardar;

    @FXML
    private Button buttonSalir;

    @FXML
    private Label labelPermisos;

    @FXML
    private ComboBox<String> comboVentana;

    @FXML
    private void initialize() {
	asignarPerfiles();
    }

    private void asignarPerfiles() {
	List<Perfil> listaPerfiles = PersistirPerfil.obtenerListaPerfil();
	for (Perfil perfil : listaPerfiles) {
	    comboPerfil.getItems().add(perfil.getNombrePerfil());
	}
    }

    private void asignarVentanas() {
	List<net.sbit.model.Ventana> listaVentanas = PersistirVentana.obtenerListaVentanas();
	for (net.sbit.model.Ventana ventana : listaVentanas) {
	    comboVentana.getItems().add(ventana.getNombreVentana());
	}
    }

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    @FXML
    void guardar(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

    @FXML
    void editarPerfil(ActionEvent event) {

    }

    @FXML
    void seleccionarPerfil(ActionEvent event) {
	comboVentana.requestFocus();
	comboVentana.setDisable(false);
	comboVentana.setPromptText("Seleccione la ventana");
	asignarVentanas();
    }

    @FXML
    void ventanaSegunPerfil(ActionEvent event) {

    }

}
