package net.sbit.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.sbit.hibernate.PersistirComponente;
import net.sbit.model.Componente;
import net.sbit.property.ComponenteProperty;
import net.sbit.window.ManejadorVentana;
import net.sbit.window.Ventana;

@SuppressWarnings("restriction")
public class ControladorListaComponentes {

    private ObservableList<ComponenteProperty> listaComponentes = FXCollections.observableArrayList();

    private Ventana ventana;

    @FXML
    private TableView<ComponenteProperty> tableViewComponentes;

    @FXML
    private TableColumn<ComponenteProperty, String> columnComponentes;

    @FXML
    private Button buttonNuevo;

    @FXML
    private Button buttonSalir;

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
	tableViewComponentes.setItems(listaComponentes);
    }

    @FXML
    private void initialize() {
	asignarComponentes();
	columnComponentes.setCellValueFactory(cellData -> cellData.getValue().componenteProperty());
    }

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

    @FXML
    void nuevo(ActionEvent event) {
	ManejadorVentana.crearComponente();
	listaComponentes.clear();
	asignarComponentes();
    }

    private void asignarComponentes() {
	List<Componente> componentes = PersistirComponente.obtenerListaComponentes();
	for (int i = 0; i < componentes.size(); i++) {
	    listaComponentes.add(new ComponenteProperty(componentes.get(i).getNombreComponente()));
	}
    }

}
