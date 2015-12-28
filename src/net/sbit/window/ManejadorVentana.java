package net.sbit.window;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javafx.scene.control.Button;
import javafx.stage.Modality;
import net.sbit.controller.ControladorAdministracionPerfil;
import net.sbit.controller.ControladorAdministracionPermisos;
import net.sbit.controller.ControladorAsignarVentanaEnComponente;
import net.sbit.controller.ControladorListaUsuario;
import net.sbit.controller.ControladorNuevoUsuario;
import net.sbit.controller.ControladorPerfil;
import net.sbit.controller.ControladorComponente;
import net.sbit.controller.ControladorListaComponentes;
import net.sbit.controller.ControladorPrincipal;
import net.sbit.controller.ControladorVentana;
import net.sbit.enums.TipoVentana;

@SuppressWarnings("restriction")
public class ManejadorVentana {

    public static List<Ventana> ventanas;

    Hashtable<TipoVentana, Integer> conversionVentana = new Hashtable<TipoVentana, Integer>();

    public ManejadorVentana() {
	ventanas = new ArrayList<Ventana>();
	conversionVentana.put(TipoVentana.PANTALLA_PRINCIPAL, 0);
	conversionVentana.put(TipoVentana.NUEVO_USUARIO, 1);

    }

    public void ventanaPrincipal() {
	Ventana ventanaPrincipal = new Ventana("file:recursos/imagenes/icon/pantalla-principal.png",
		"Pantalla Principal", "/net/sbit/view/principal.fxml", TipoVentana.PANTALLA_PRINCIPAL);
	ventanas.add(ventanaPrincipal);
	ControladorPrincipal controladorPrincipal = ventanas
		.get(conversionVentana.get(ventanaPrincipal.getTipoVentana())).getLoader().getController();
	controladorPrincipal.setVentana(ventanaPrincipal);
	Button boton1 = (Button) ventanaPrincipal.getComponentes().get("button");
	boton1.setText(" =')  !!! ");
	ventanaPrincipal.mostrarVentana();

    }

    public static void nuevoUsuario() {
	Ventana ventanaNuevoUsuario = new Ventana("file:recursos/imagenes/icon/nuevo-usuario.png", "Nuevo Usuario",
		"/net/sbit/view/nuevoUsuario.fxml", TipoVentana.NUEVO_USUARIO);
	ventanas.add(ventanaNuevoUsuario);
	ControladorNuevoUsuario controladorPrincipal = ventanas.get(ventanas.size() - 1).getLoader().getController();
	controladorPrincipal.setVentana(ventanaNuevoUsuario);
	ventanaNuevoUsuario.getEscenario().initModality(Modality.APPLICATION_MODAL);
	ventanaNuevoUsuario.mostrarEsperar();
    }

    public static void listaUsuarios() {
	Ventana ventanaListaUsuarios = new Ventana("file:recursos/imagenes/icon/lista-usuarios.png", "Lista Usuarios",
		"/net/sbit/view/listaUsuario.fxml", TipoVentana.LISTA_USUARIOS);
	ventanas.add(ventanaListaUsuarios);
	ControladorListaUsuario controladorPrincipal = ventanas.get(ventanas.size() - 1).getLoader().getController();
	controladorPrincipal.setVentana(ventanaListaUsuarios);
	ventanaListaUsuarios.getEscenario().initModality(Modality.APPLICATION_MODAL);
	ventanaListaUsuarios.mostrarEsperar();
    }

    public static void administrarPermisos() {
	Ventana ventanaAdministrarPermisos = new Ventana("file:recursos/imagenes/icon/administrarPermisos.png",
		"Administrar Permiso en Ventana", "/net/sbit/view/AdministracionPermisos.fxml",
		TipoVentana.ADMINISTRAR_PERMISO_EN_VENTANA);
	ventanas.add(ventanaAdministrarPermisos);
	ControladorAdministracionPermisos controladorAdministracionPermisos = ventanas.get(ventanas.size() - 1)
		.getLoader().getController();
	controladorAdministracionPermisos.setVentana(ventanaAdministrarPermisos);
	ventanaAdministrarPermisos.getEscenario().initModality(Modality.APPLICATION_MODAL);
	ventanaAdministrarPermisos.mostrarEsperar();
    }

    public static void crearPerfil() {
	Ventana ventanaCrearPerfil = new Ventana("file:recursos/imagenes/icon/crearPerfil.png", "Crear Perfil",
		"/net/sbit/view/perfil.fxml", TipoVentana.CREAR_PERFIL);
	ventanas.add(ventanaCrearPerfil);
	ControladorPerfil controladorPerfil = ventanas.get(ventanas.size() - 1).getLoader().getController();
	controladorPerfil.setVentana(ventanaCrearPerfil);
	ventanaCrearPerfil.getEscenario().initModality(Modality.APPLICATION_MODAL);
	ventanaCrearPerfil.mostrarEsperar();
    }

    public static void adminisrarPerfil() {
	Ventana ventanaAdministrarPerfil = new Ventana("file:recursos/imagenes/icon/administrarPerfil.png",
		"Asignar ventanas a  perfil", "/net/sbit/view/AdministracionPerfil.fxml",
		TipoVentana.ADMINISTRAR_VENTANAS_A_PERFIL);
	ventanas.add(ventanaAdministrarPerfil);
	ControladorAdministracionPerfil controladorAdministrarPerfil = ventanas.get(ventanas.size() - 1).getLoader()
		.getController();
	controladorAdministrarPerfil.setVentana(ventanaAdministrarPerfil);
	ventanaAdministrarPerfil.getEscenario().initModality(Modality.APPLICATION_MODAL);
	ventanaAdministrarPerfil.mostrarEsperar();

    }

    public static void crearComponente() {
	Ventana ventanaCrearPermiso = new Ventana("file:recursos/imagenes/icon/nuevoPermiso.png", "Nuevo Componente",
		"/net/sbit/view/componente.fxml", TipoVentana.NUEVO_COMPONENTE);
	ventanas.add(ventanaCrearPermiso);
	ControladorComponente controladorNuevoPermiso = ventanas.get(ventanas.size() - 1).getLoader().getController();
	controladorNuevoPermiso.setVentana(ventanaCrearPermiso);
	ventanaCrearPermiso.getEscenario().initModality(Modality.APPLICATION_MODAL);
	ventanaCrearPermiso.mostrarEsperar();
    }

    public static void listarComponentes() {
	Ventana ventanaListaComponentes = new Ventana("file:recursos/imagenes/icon/listarComponentes.png",
		"Listar Componentes", "/net/sbit/view/listaComponentes.fxml", TipoVentana.LISTAR_COMPONENTES);
	ventanas.add(ventanaListaComponentes);
	ControladorListaComponentes controladorListarComponentes = ventanas.get(ventanas.size() - 1).getLoader()
		.getController();
	controladorListarComponentes.setVentana(ventanaListaComponentes);
	ventanaListaComponentes.getEscenario().initModality(Modality.APPLICATION_MODAL);
	ventanaListaComponentes.mostrarEsperar();
    }

    public static void crearVentana() {
	Ventana nuevaVentana = new Ventana("file:recursos/imagenes/icon/nuevaVentana.png", "Nueva Ventana",
		"/net/sbit/view/ventana.fxml", TipoVentana.NUEVA_VENTANA);
	ventanas.add(nuevaVentana);
	ControladorVentana controladorVentana = ventanas.get(ventanas.size() - 1).getLoader().getController();
	controladorVentana.setVentana(nuevaVentana);
	nuevaVentana.getEscenario().initModality(Modality.APPLICATION_MODAL);
	nuevaVentana.mostrarEsperar();
    }

    public static void AsignarComponenteAVentana() {
	Ventana nuevaVentana = new Ventana("file:recursos/imagenes/icon/asignarComponenteEnVentana.png",
		"Asiganar Componentes", "/net/sbit/view/asignarComponenteEnVentana.fxml",
		TipoVentana.ASIGNAR_COMPONENTE_A_VENTANA);
	ventanas.add(nuevaVentana);
	ControladorAsignarVentanaEnComponente controladorAVEC = ventanas.get(ventanas.size() - 1).getLoader()
		.getController();
	controladorAVEC.setVentana(nuevaVentana);
	nuevaVentana.getEscenario().initModality(Modality.APPLICATION_MODAL);
	nuevaVentana.mostrarEsperar();
    }

}
