package net.sbit.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import net.sbit.window.ManejadorVentana;
import net.sbit.window.Ventana;

@SuppressWarnings("restriction")
public class ControladorPrincipal {

    private Ventana ventana;

    @FXML
    private MenuItem menuItemAsignarComponentes;

    @FXML
    private MenuItem menuItemNuevoPermiso;

    @FXML
    private Menu menuAyuda;

    @FXML
    private Menu MenuVentana;

    @FXML
    private MenuItem menuItemNuevaVentana;

    @FXML
    private Menu menuArchivo;

    @FXML
    private MenuItem menuItemSalir;

    @FXML
    private Menu menuPerfiles;

    @FXML
    private Menu menuAdministrar;

    @FXML
    private MenuItem menuItemCrearUsuario;

    @FXML
    private Button button;

    @FXML
    private MenuBar menuBar;

    @FXML
    private ToolBar toolBar;

    @FXML
    private Menu menuUsuarios;

    @FXML
    private Menu MenuPermisos;

    @FXML
    private MenuItem menuItemListarUsuarios;

    @FXML
    private MenuItem menuItemCrearPerfil;

    @FXML
    private MenuItem menuItemAdministrarPerfiles;

    @FXML
    private Label labelUsuario;

    @FXML
    private MenuItem menuItemAdministrarPermisos;

    @FXML
    private MenuItem menuItemListarComponentes;

    public Ventana getVentana() {
	return ventana;
    }

    public void setVentana(Ventana ventana) {
	this.ventana = ventana;
    }

    // BEGIN Getters y Setters

    public Menu getMenuAyuda() {
	return menuAyuda;
    }

    public Menu getMenuArchivo() {
	return menuArchivo;
    }

    public MenuItem getMenuItemSalir() {
	return menuItemSalir;
    }

    public Menu getMenuPerfiles() {
	return menuPerfiles;
    }

    public Menu getMenuAdministrar() {
	return menuAdministrar;
    }

    public MenuItem getMenuItemCrearUsuario() {
	return menuItemCrearUsuario;
    }

    public Button getButton() {
	return button;
    }

    public MenuBar getMenuBar() {
	return menuBar;
    }

    public ToolBar getToolBar() {
	return toolBar;
    }

    public Menu getMenuUsuarios() {
	return menuUsuarios;
    }

    public Menu getMenuPermisos() {
	return MenuPermisos;
    }

    public MenuItem getMenuItemListarUsuarios() {
	return menuItemListarUsuarios;
    }

    public MenuItem getMenuItemCrearPerfil() {
	return menuItemCrearPerfil;
    }

    public MenuItem getMenuItemAdministrarPerfiles() {
	return menuItemAdministrarPerfiles;
    }

    public Label getLabelUsuario() {
	return labelUsuario;
    }

    public MenuItem getMenuItemAdministrarPermisos() {
	return menuItemAdministrarPermisos;
    }

    public void setMenuAyuda(Menu menuAyuda) {
	this.menuAyuda = menuAyuda;
    }

    public void setMenuArchivo(Menu menuArchivo) {
	this.menuArchivo = menuArchivo;
    }

    public void setMenuItemSalir(MenuItem menuItemSalir) {
	this.menuItemSalir = menuItemSalir;
    }

    public void setMenuPerfiles(Menu menuPerfiles) {
	this.menuPerfiles = menuPerfiles;
    }

    public void setMenuAdministrar(Menu menuAdministrar) {
	this.menuAdministrar = menuAdministrar;
    }

    public void setMenuItemCrearUsuario(MenuItem menuItemCrearUsuario) {
	this.menuItemCrearUsuario = menuItemCrearUsuario;
    }

    public void setButton(Button button) {
	this.button = button;
    }

    public void setMenuBar(MenuBar menuBar) {
	this.menuBar = menuBar;
    }

    public void setToolBar(ToolBar toolBar) {
	this.toolBar = toolBar;
    }

    public void setMenuUsuarios(Menu menuUsuarios) {
	this.menuUsuarios = menuUsuarios;
    }

    public void setMenuPermisos(Menu menuPermisos) {
	MenuPermisos = menuPermisos;
    }

    public void setMenuItemListarUsuarios(MenuItem menuItemListarUsuarios) {
	this.menuItemListarUsuarios = menuItemListarUsuarios;
    }

    public void setMenuItemCrearPerfil(MenuItem menuItemCrearPerfil) {
	this.menuItemCrearPerfil = menuItemCrearPerfil;
    }

    public void setMenuItemAdministrarPerfiles(MenuItem menuItemAdministrarPerfiles) {
	this.menuItemAdministrarPerfiles = menuItemAdministrarPerfiles;
    }

    public void setLabelUsuario(Label labelUsuario) {
	this.labelUsuario = labelUsuario;
    }

    public void setMenuItemAdministrarPermisos(MenuItem menuItemAdministrarPermisos) {
	this.menuItemAdministrarPermisos = menuItemAdministrarPermisos;
    }

    public MenuItem getMenuItemNuevoPermiso() {
	return menuItemNuevoPermiso;
    }

    public void setMenuItemNuevoPermiso(MenuItem menuItemNuevoPermiso) {
	this.menuItemNuevoPermiso = menuItemNuevoPermiso;
    }

    public MenuItem getMenuItemListarComponentes() {
	return menuItemListarComponentes;
    }

    public void setMenuItemListarComponentes(MenuItem menuItemListarComponentes) {
	this.menuItemListarComponentes = menuItemListarComponentes;
    }

    // END Getters y Setters

    @FXML
    void salir(ActionEvent event) {
	ventana.getEscenario().close();
    }

    @FXML
    void listaUsuarios(ActionEvent event) {
	ManejadorVentana.listaUsuarios();
    }

    @FXML
    void crearUsuario(ActionEvent event) {
	ManejadorVentana.nuevoUsuario();
    }

    @FXML
    void administrarPermisos(ActionEvent event) {
	ManejadorVentana.administrarPermisos();
    }

    @FXML
    void crearPerfil(ActionEvent event) {
	ManejadorVentana.crearPerfil();
    }

    @FXML
    void administrarPerfiles(ActionEvent event) {
	ManejadorVentana.adminisrarPerfil();
    }

    @FXML
    void nuevoPermiso(ActionEvent event) {
	ManejadorVentana.crearComponente();
    }

    @FXML
    void listarComponentes(ActionEvent event) {
	ManejadorVentana.listarComponentes();
    }

    @FXML
    void nuevaVentana(ActionEvent event) {
	ManejadorVentana.crearVentana();
    }

    @FXML
    void asignarComponentes(ActionEvent event) {
	ManejadorVentana.AsignarComponenteAVentana();
    }
}