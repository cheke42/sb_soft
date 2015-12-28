package net.sbit.window;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.sbit.enums.TipoVentana;
import net.sbit.util.Utilidades;

@SuppressWarnings("restriction")
public class Ventana {

    private int ventana;
    private Stage escenario;
    private String pathIcon;
    private String pathFXML;
    private TipoVentana tipoVentana;
    private FXMLLoader loader;
    private List<Node> listaComponentes;
    private Hashtable<String, Node> componentes = new Hashtable<String, Node>();

    // Construir con Parent, direccion del icono y titulo de la ventana
    public Ventana(String pathicon, String titulo, String pathFXML, TipoVentana tipoVentana) {
	escenario = new Stage();
	loader = new FXMLLoader();
	escenario.setTitle(titulo);
	this.pathIcon = pathicon;
	this.pathFXML = pathFXML;
	this.tipoVentana = tipoVentana;
	listaComponentes = new ArrayList<Node>();

	try {
	    crearStage(pathFXML);
	    listaComponentes = referenciarComponentes();
	    referenciarNodos();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public FXMLLoader getLoader() {
	return loader;
    }

    public void setLoader(FXMLLoader loader) {
	this.loader = loader;
    }

    public String getPathIcon() {
	return pathIcon;
    }

    public void setPathIcon(String pathIcon) {
	this.pathIcon = pathIcon;
    }

    public int getVentana() {
	return ventana;
    }

    public void setVentana(int ventana) {
	this.ventana = ventana;
    }

    public String getPathFXML() {
	return pathFXML;
    }

    public void setPathFXML(String pathFXML) {
	this.pathFXML = pathFXML;
    }

    public Stage getEscenario() {
	return escenario;
    }

    public void setEscenario(Stage escenario) {
	this.escenario = escenario;
    }

    public TipoVentana getTipoVentana() {
	return tipoVentana;
    }

    public void setTipoVentana(TipoVentana tipoVentana) {
	this.tipoVentana = tipoVentana;
    }

    public List<Node> getListaComponentes() {
	return listaComponentes;
    }

    public Hashtable<String, Node> getComponentes() {
	return componentes;
    }

    public void setListaComponentes(List<Node> listaComponentes) {
	this.listaComponentes = listaComponentes;
    }

    public void setComponentes(Hashtable<String, Node> componentes) {
	this.componentes = componentes;
    }

    private ObservableList<Node> referenciarComponentes() {
	return this.escenario.getScene().getRoot().getChildrenUnmodifiable();
    }

    private void referenciarNodos() {
	for (int i = 0; i < this.escenario.getScene().getRoot().getChildrenUnmodifiable().size(); i++) {
	    this.componentes.put(this.escenario.getScene().getRoot().getChildrenUnmodifiable().get(i).getId(),
		    this.escenario.getScene().getRoot().getChildrenUnmodifiable().get(i));
	}

    }

    public Stage crearVentana(Stage escenario, FXMLLoader loader) throws Exception {
	loader.setLocation(Utilidades.restToURL(this.pathFXML));
	Scene escena = new Scene((Pane) loader.load());
	escenario.setScene(escena);
	escenario.setResizable(false);
	escenario.sizeToScene();
	escenario.getIcons().add(new Image(this.pathIcon));
	return escenario;
    }

    public void crearStage(String urlFXML) throws Exception {
	this.escenario = crearVentana(this.escenario, this.loader);
    }

    public void mostrarVentana() {
	this.escenario.show();
    }

    public void cerrarVentana() {
	this.escenario.close();
    }

    public void mostrarEsperar() {
	this.escenario.showAndWait();
    }

}
