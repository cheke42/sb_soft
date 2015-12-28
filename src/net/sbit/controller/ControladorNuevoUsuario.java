package net.sbit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.sbit.window.Ventana;
@SuppressWarnings("restriction")
public class ControladorNuevoUsuario {

    private Ventana ventana;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private PasswordField fieldPasswordRepite;

    @FXML
    private TextField fieldUsuario;

    @FXML
    private CheckBox checkBoxAdministrador;

    @FXML
    private DatePicker datePickerFechaCreacion;

    @FXML
    private Button buttonGuardar;

    @FXML
    private CheckBox checkBoxOperador;

    @FXML
    private Button buttonSalir;

    public PasswordField getFieldPassword() {
	return fieldPassword;
    }

    public PasswordField getFieldPasswordRepite() {
	return fieldPasswordRepite;
    }

    public TextField getFieldUsuario() {
	return fieldUsuario;
    }

    public CheckBox getCheckBoxAdministrador() {
	return checkBoxAdministrador;
    }

    public DatePicker getDatePickerFechaCreacion() {
	return datePickerFechaCreacion;
    }

    public Button getButtonGuardar() {
	return buttonGuardar;
    }

    public CheckBox getCheckBoxOperador() {
	return checkBoxOperador;
    }

    public Button getButtonSalir() {
	return buttonSalir;
    }

    public void setFieldPassword(PasswordField fieldPassword) {
	this.fieldPassword = fieldPassword;
    }

    public void setFieldPasswordRepite(PasswordField fieldPasswordRepite) {
	this.fieldPasswordRepite = fieldPasswordRepite;
    }

    public void setFieldUsuario(TextField fieldUsuario) {
	this.fieldUsuario = fieldUsuario;
    }

    public void setCheckBoxAdministrador(CheckBox checkBoxAdministrador) {
	this.checkBoxAdministrador = checkBoxAdministrador;
    }

    public void setDatePickerFechaCreacion(DatePicker datePickerFechaCreacion) {
	this.datePickerFechaCreacion = datePickerFechaCreacion;
    }

    public void setButtonGuardar(Button buttonGuardar) {
	this.buttonGuardar = buttonGuardar;
    }

    public void setCheckBoxOperador(CheckBox checkBoxOperador) {
	this.checkBoxOperador = checkBoxOperador;
    }

    public void setButtonSalir(Button buttonSalir) {
	this.buttonSalir = buttonSalir;
    }

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

    @FXML
    void guardar(ActionEvent event) {

    }

}
