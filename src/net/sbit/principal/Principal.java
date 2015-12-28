package net.sbit.principal;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sbit.hibernate.HibernateUtil;
import net.sbit.hibernate.PersistirVentana;
import net.sbit.window.ManejadorVentana;

@SuppressWarnings("restriction")
public class Principal extends Application {
    public Stage escenarioPrincipal;

    public static void main(String[] args) {
	HibernateUtil.getSessionFactory();

	launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

	ManejadorVentana manejador = new ManejadorVentana();
	PersistirVentana.agregarVentanasNuevas();
	manejador.ventanaPrincipal();

    }

}
