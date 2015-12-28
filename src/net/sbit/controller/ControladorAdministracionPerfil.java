package net.sbit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import net.sbit.window.Ventana;
@SuppressWarnings("restriction")
public class ControladorAdministracionPerfil {

    private Ventana ventana;

    @FXML
    private ImageView imageEditarPerfil;

    @FXML
    private Label labelPerfil;

    @FXML
    private ComboBox<?> comboPerfil;

    @FXML
    private TableColumn<?, ?> columnVentana;

    @FXML
    private TableColumn<?, ?> columnVisible;

    @FXML
    private TableView<?> tableViewVentanas;

    @FXML
    private Button buttonGuardar;

    @FXML
    private Button buttonEditarPerfil;

    @FXML
    private Button buttonSalir;

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    @FXML
    void editarPerfil(ActionEvent event) {

    }

    @FXML
    void guardar(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

}
