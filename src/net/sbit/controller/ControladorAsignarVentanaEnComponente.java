package net.sbit.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import net.sbit.model.Componente;
import net.sbit.model.VentanaComponente;
import net.sbit.window.PairKeyFactory;
import net.sbit.window.PairValueCell;
import net.sbit.window.PairValueFactory;
import net.sbit.window.Ventana;

@SuppressWarnings("restriction")
public class ControladorAsignarVentanaEnComponente {
	private Ventana ventana;

	private List<Componente> componentes = new ArrayList<Componente>();

	private ObservableList<String> listaAnterior = FXCollections.observableArrayList();

	private Hashtable<TipoVentana, ObservableList<Pair<String, Object>>> hashVentanas = new Hashtable<TipoVentana, ObservableList<Pair<String, Object>>>();

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
		CheckBox ch = (CheckBox) columnCheckIncluido.getCellData(0);

	}

	@SuppressWarnings("unused")
	private Pair<TipoVentana, ObservableList<Pair<String, Object>>> pair2(TipoVentana name,
			ObservableList<Pair<String, Object>> value) {
		return new Pair<>(name, value);
	}

	private Pair<String, Object> pair(String name, Object value) {
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
			hashVentanas.put(tipoVentana,
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
		tableComponentes.setDisable(false);

		String ventanaSeleccionada = comboVentana.getItems().get(comboVentana.getSelectionModel().getSelectedIndex());
		listaAnterior.add(ventanaSeleccionada);
		tableComponentes.getItems().clear();
		tableComponentes.setItems(hashVentanas.get(TipoVentana.valueOf(ventanaSeleccionada)));
		System.out.println(tableComponentes.getItems().get(0).getValue());
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

}
