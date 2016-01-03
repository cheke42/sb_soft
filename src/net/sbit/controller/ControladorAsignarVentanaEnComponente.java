
package net.sbit.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import javafx.util.Callback;
import javafx.util.Pair;
import net.sbit.enums.TipoVentana;
import net.sbit.hibernate.PersistirComponente;
import net.sbit.hibernate.PersistirVentana;
import net.sbit.hibernate.PersistirVentanaComponente;
import net.sbit.model.Componente;
import net.sbit.model.VentanaComponente;
import net.sbit.window.PairKeyFactory;
import net.sbit.window.PairValueCell;
import net.sbit.window.PairValueFactory;
import net.sbit.window.Ventana;

public class ControladorAsignarVentanaEnComponente {
    private Ventana ventana;

    public static String ventanaActual;

    private List<Componente> componentes = new ArrayList<Componente>();

    private ObservableList<String> listaAnterior = FXCollections.observableArrayList();

    public static Hashtable<TipoVentana, ObservableList<Pair<String, Object>>> hashVentanasDinamicas = new Hashtable<TipoVentana, ObservableList<Pair<String, Object>>>();

    public static Hashtable<TipoVentana, ObservableList<Pair<String, Object>>> hashVentanasEnBase = new Hashtable<TipoVentana, ObservableList<Pair<String, Object>>>();

    @FXML
    private TableColumn<Pair<String, Object>, Object> columnCheckIncluido;

    @FXML
    private TableColumn<Pair<String, Object>, Object> columnNombreComponente;

    @FXML
    private TableView<Pair<String, Object>> tableComponentes;

    @FXML
    private Button buttonGuardar;

    @FXML
    private ComboBox<String> comboVentana;

    @FXML
    private Label labelSeleccionarVentana;

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    @FXML
    private void initialize() {
	componentes = PersistirComponente.obtenerListaComponentes();
	asignarVentanas();
	setearTabla();

    }

    @SuppressWarnings("unused")
    private Pair<TipoVentana, ObservableList<Pair<String, Object>>> pair2(TipoVentana name,
	    ObservableList<Pair<String, Object>> value) {
	return new Pair<>(name, value);
    }

    private static Pair<String, Object> pair(String name, Object value) {
	return new Pair<>(name, value);
    }

    public TableView<Pair<String, Object>> getTableComponentes() {
	return tableComponentes;
    }

    public void setTableComponentes(TableView<Pair<String, Object>> tableComponentes) {
	this.tableComponentes = tableComponentes;
    }

    @FXML
    void guardar(ActionEvent event) {
	TipoVentana vtn = TipoVentana
		.valueOf(comboVentana.getItems().get(comboVentana.getSelectionModel().getSelectedIndex()));
	hashVentanasDinamicas.remove(vtn);
	hashVentanasDinamicas.put(vtn, tableComponentes.getItems());
	for (TipoVentana tipoVentana : TipoVentana.values()) {
	    ObservableList<Pair<String, Object>> li = hashVentanasEnBase.get(tipoVentana);
	    for (int i = 0; i < li.size(); i++) {
		Pair<String, Object> parEnBase = hashVentanasEnBase.get(tipoVentana).get(i);
		Pair<String, Object> parDinamico = devolverPair(hashVentanasEnBase.get(tipoVentana).get(i).getKey(),
			hashVentanasDinamicas.get(tipoVentana));
		if (parEnBase.getKey().equals(parDinamico.getKey())) {
		    if (!parEnBase.getValue().equals(parDinamico.getValue())) {
			if (!(Boolean) parEnBase.getValue()) {
			    PersistirVentanaComponente.nueva(tipoVentana.toString(), parDinamico.getKey());
			} else {
			    PersistirVentanaComponente.borrar(tipoVentana.toString(), parDinamico.getKey());
			}
		    }
		}
	    }
	}
	salir(null);
    }

    private Pair<String, Object> devolverPair(String key, ObservableList<Pair<String, Object>> lista) {
	Pair<String, Object> par = null;
	for (int i = 0; i < lista.size(); i++) {
	    if (lista.get(i).getKey().equals(key)) {
		par = lista.get(i);
	    }
	}
	return par;
    }

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

    @SuppressWarnings("unchecked")
    private void asignarVentanas() {
	List<net.sbit.model.Ventana> listaVentanas = PersistirVentana.obtenerListaVentanas();
	for (int i = 0; i < listaVentanas.size(); i++) {
	    comboVentana.getItems().add(listaVentanas.get(i).getNombreVentana());
	}
	for (TipoVentana tipoVentana : TipoVentana.values()) {
	    hashVentanasEnBase.put(tipoVentana,
		    juntarListas(
			    (List<VentanaComponente>) PersistirVentana.obtenerListaComponentes(tipoVentana.toString()),
			    componentes));
	    hashVentanasDinamicas.put(tipoVentana,
		    juntarListas(
			    (List<VentanaComponente>) PersistirVentana.obtenerListaComponentes(tipoVentana.toString()),
			    componentes));
	}
    }

    @SuppressWarnings("unchecked")
    private void setearTabla() {
	TableColumn<Pair<String, Object>, String> nameColumn = new TableColumn<>("Componente");
	TableColumn<Pair<String, Object>, Object> valueColumn = new TableColumn<>("Seleccionado");
	nameColumn.setCellValueFactory(new PairKeyFactory());
	valueColumn.setCellValueFactory(new PairValueFactory());
	valueColumn.setSortable(false);
	valueColumn.setStyle("-fx-alignment: CENTER;");
	tableComponentes.getColumns().setAll(nameColumn, valueColumn);
	tableComponentes.setPlaceholder(new Label(""));
	valueColumn.setCellFactory(
		new Callback<TableColumn<Pair<String, Object>, Object>, TableCell<Pair<String, Object>, Object>>() {
		    @Override
		    public TableCell<Pair<String, Object>, Object> call(
			    TableColumn<Pair<String, Object>, Object> column) {
			return new PairValueCell();
		    }
		});
	tableComponentes.setDisable(true);
    }

    @FXML
    void comboVentanaAction(ActionEvent event) {
	ventanaActual = comboVentana.getItems().get(comboVentana.getSelectionModel().getSelectedIndex());
	if (!listaAnterior.isEmpty()) {
	    TipoVentana ultimaVentanaSeleccionada = TipoVentana.valueOf(listaAnterior.get(listaAnterior.size() - 1));
	    hashVentanasDinamicas.remove(ultimaVentanaSeleccionada);
	    hashVentanasDinamicas.put(ultimaVentanaSeleccionada, ActualizarValoresLista(tableComponentes.getItems()));
	}
	tableComponentes.setDisable(false);
	String ventanaSeleccionada = comboVentana.getItems().get(comboVentana.getSelectionModel().getSelectedIndex());
	listaAnterior.add(ventanaSeleccionada);
	tableComponentes.setItems(hashVentanasDinamicas.get(TipoVentana.valueOf(ventanaSeleccionada)));

    }

    private ObservableList<Pair<String, Object>> ActualizarValoresLista(
	    ObservableList<Pair<String, Object>> listaNueva) {
	ObservableList<Pair<String, Object>> lista = FXCollections.observableArrayList();
	listaAnterior.clear();
	for (int i = 0; i < listaNueva.size(); i++) {
	    lista.add(pair(listaNueva.get(i).getKey(), listaNueva.get(i).getValue()));
	}
	return lista;
    }

    // Chequea si existe un componente en la lista de componentes de una ventana
    private Boolean existeComponente(List<VentanaComponente> listaComp, String elem) {
	Boolean existe = false;
	for (int i = 0; i < listaComp.size(); i++) {
	    if (listaComp.get(i).getId().getNomComponente().equals(elem)) {
		existe = true;
	    }
	}
	return existe;
    }

    // Devuelve la union de una lista con componentes seleccionados en true y el
    // resto en false
    private ObservableList<Pair<String, Object>> juntarListas(List<VentanaComponente> componentesExisten,
	    List<Componente> listaComponetnes) {
	ObservableList<Pair<String, Object>> listaUnificada = FXCollections.observableArrayList();
	for (int i = 0; i < listaComponetnes.size(); i++) {
	    if (existeComponente(componentesExisten, listaComponetnes.get(i).getNombreComponente())) {
		listaUnificada.add(pair(listaComponetnes.get(i).getNombreComponente(), true));
	    } else {
		listaUnificada.add(pair(listaComponetnes.get(i).getNombreComponente(), false));
	    }
	}
	return listaUnificada;
    }

    public static void modificarValorEnObservableList(String key) {
	ObservableList<Pair<String, Object>> ventanaSelc = hashVentanasDinamicas
		.get(TipoVentana.valueOf(ventanaActual));
	cambiarEstadoPair(ventanaSelc, key);

    }

    public static void cambiarEstadoPair(ObservableList<Pair<String, Object>> lista, String key) {
	Boolean estado = false;
	if (!lista.isEmpty()) {
	    for (int i = 0; i < lista.size(); i++) {
		if (lista.get(i).getKey().equals(key)) {
		    estado = !(Boolean) lista.get(i).getValue();
		    lista.remove(i);
		}
	    }
	}
	lista.add(pair(key, estado));
	Collections.sort(lista, new Comparator<Pair<String, Object>>() {

	    @Override
	    public int compare(Pair<String, Object> o1, Pair<String, Object> o2) {
		int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getKey(), o2.getKey());
		if (res == 0) {
		    res = o1.getKey().compareTo(o2.getKey());
		}
		return res;
	    }

	});
    }

}
