package net.sbit.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.Pair;
import net.sbit.enums.TipoVentana;
import net.sbit.hibernate.PersistirComponente;
import net.sbit.hibernate.PersistirPerfil;
import net.sbit.hibernate.PersistirVentana;
import net.sbit.model.Componente;
import net.sbit.model.Perfil;
import net.sbit.model.VentanaComponente;
import net.sbit.window.PairKeyFactory;
import net.sbit.window.PairValueCell;
import net.sbit.window.PairValueFactory;
import net.sbit.window.Ventana;

public class ControladorAdministracionPermisos {

    private Ventana ventana;

    @FXML
    private Label labelVentana;

    @FXML
    private Label labelPerfil;

    @SuppressWarnings("unused")
    private List<Componente> componentes = new ArrayList<Componente>();

    public static Hashtable<TipoVentana, ObservableList<Pair<String, Object>>> hashVentanasDinamicas = new Hashtable<TipoVentana, ObservableList<Pair<String, Object>>>();

    @FXML
    private ComboBox<String> comboPerfil;

    @FXML
    private TableView<Pair<String, Object>> tableViewPermisos;

    @FXML
    private TableColumn<Pair<String, Object>, Object> columnId;

    @FXML
    private TableColumn<Pair<String, Object>, Object> columnEstado;

    @FXML
    private Button buttonEditarPerfil;

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
	componentes = PersistirComponente.obtenerListaComponentes();
	asignarPerfiles();
	asignarTabla();
    }

    @SuppressWarnings("unchecked")
    private void asignarTabla() {
	TableColumn<Pair<String, Object>, String> nameColumn = new TableColumn<>("Componente");
	TableColumn<Pair<String, Object>, Object> valueColumn = new TableColumn<>("Seleccionado");
	nameColumn.setCellValueFactory(new PairKeyFactory());
	valueColumn.setCellValueFactory(new PairValueFactory());
	valueColumn.setSortable(false);
	valueColumn.setStyle("-fx-alignment: CENTER;");
	tableViewPermisos.getColumns().setAll(nameColumn, valueColumn);
	tableViewPermisos.setPlaceholder(new Label(""));
	valueColumn.setCellFactory(
		new Callback<TableColumn<Pair<String, Object>, Object>, TableCell<Pair<String, Object>, Object>>() {
		    @Override
		    public TableCell<Pair<String, Object>, Object> call(
			    TableColumn<Pair<String, Object>, Object> column) {
			return new PairValueCell();
		    }
		});
	tableViewPermisos.setDisable(true);
    }

    private ObservableList<Pair<String, Object>> juntarListas(List<VentanaComponente> componentesExisten,
	    List<Componente> listaComponetnes) {
	ObservableList<Pair<String, Object>> listaUnificada = FXCollections.observableArrayList();
	for (int i = 0; i < listaComponetnes.size(); i++) {
	    if (existeComponente(componentesExisten, listaComponetnes.get(i).getNombreComponente())) {
		listaUnificada.add(pair(listaComponetnes.get(i).getNombreComponente(), null));
	    }
	}
	return listaUnificada;
    }

    private static Pair<String, Object> pair(String name, Object value) {
	return new Pair<>(name, value);
    }

    private Boolean existeComponente(List<VentanaComponente> listaComp, String elem) {
	Boolean existe = false;
	for (int i = 0; i < listaComp.size(); i++) {
	    if (listaComp.get(i).getId().getNomComponente().equals(elem)) {
		existe = true;
	    }
	}
	return existe;
    }

    private void asignarPerfiles() {
	List<Perfil> listaPerfiles = PersistirPerfil.obtenerListaPerfil();
	for (Perfil perfil : listaPerfiles) {
	    comboPerfil.getItems().add(perfil.getNombrePerfil());
	}
    }

    @SuppressWarnings("unchecked")
    private void asignarVentanas() {
	List<net.sbit.model.Ventana> listaVentanas = PersistirVentana.obtenerListaVentanas();
	for (net.sbit.model.Ventana ventana : listaVentanas) {
	    comboVentana.getItems().add(ventana.getNombreVentana());
	}
	for (TipoVentana tipoVentana : TipoVentana.values()) {
	    hashVentanasDinamicas.put(tipoVentana,
		    juntarListas(
			    (List<VentanaComponente>) PersistirVentana.obtenerListaComponentes(tipoVentana.toString()),
			    componentes));
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

	tableViewPermisos.getItems().clear();
	comboVentana.getSelectionModel().clearSelection();
	comboVentana.requestFocus();
	comboVentana.setDisable(false);
	comboVentana.setPromptText("Seleccione la ventana");
	asignarVentanas();
    }

    @FXML
    void ventanaSegunPerfil(ActionEvent event) {
	tableViewPermisos.setDisable(false);
	String ventanaSeleccionada = null;
	try {
	    ventanaSeleccionada = comboVentana.getItems().get(comboVentana.getSelectionModel().getSelectedIndex());
	} catch (Exception e) {
	    // TODO: handle exception
	}
	tableViewPermisos.setItems(hashVentanasDinamicas.get(TipoVentana.valueOf(ventanaSeleccionada)));
    }

}
