package net.sbit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.sbit.window.Ventana;
@SuppressWarnings("restriction")
public class ControladorListaUsuario {

    private Ventana ventana;

    @FXML
    private TableColumn<?, ?> colUsuario;

    @FXML
    private Button buttonVer;

    @FXML
    private TableColumn<?, ?> colEstado;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Button buttonSalir;

    @FXML
    private TableColumn<?, ?> colFechaCreacion;

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    @FXML
    void salir(ActionEvent event) {

    }

    @FXML
    void ver(ActionEvent event) {
	ventana.getEscenario().close();
    }

}
