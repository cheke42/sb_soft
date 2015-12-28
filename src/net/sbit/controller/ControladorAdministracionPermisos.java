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
public class ControladorAdministracionPermisos {

    private Ventana ventana;

    @FXML
    private Label labelVentana;

    @FXML
    private Label labelPerfil;

    @FXML
    private ComboBox<?> comboPerfil;

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
    private ComboBox<?> comboVentana;

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

}