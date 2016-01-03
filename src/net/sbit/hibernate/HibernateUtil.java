package net.sbit.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import net.sbit.model.Componente;
import net.sbit.model.Perfil;
import net.sbit.model.PerfilVentanaComponente;
import net.sbit.model.PerfilVentanaComponenteId;
import net.sbit.model.Ventana;
import net.sbit.model.VentanaComponente;
import net.sbit.model.VentanaComponenteId;

@SuppressWarnings({ "deprecation" })
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /*
     * BUILD_SESSION_FACTORY: Construye la session y asocia las clases con
     * anotaciones
     */
    private static SessionFactory buildSessionFactory() {
	try {
	    AnnotationConfiguration config = new AnnotationConfiguration();
	    config.addAnnotatedClass(Perfil.class);
	    config.addAnnotatedClass(Componente.class);
	    config.addAnnotatedClass(Ventana.class);
	    config.addAnnotatedClass(PerfilVentanaComponente.class);
	    config.addAnnotatedClass(PerfilVentanaComponenteId.class);
	    config.addAnnotatedClass(VentanaComponente.class);
	    config.addAnnotatedClass(VentanaComponenteId.class);
	    config.configure("hibernate.cfg.xml");
	    return config.buildSessionFactory();
	} catch (Throwable ex) {
	    System.err.println("Error en la creaccion de SessionFactory." + ex);
	    throw new ExceptionInInitializerError(ex);
	}
    }

    /*
     * GET_SESSION_FACTORY: Retorna la unica sessión abierta entre la base e
     * hibernate durante todo el programa, si no existe la construye
     */
    public static SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    /*
     * SETEAR_VALORES_INICIALES: Recorre los enums de TipoVentana y TipoPerfil y
     * los sincroniza con la base de datos
     */
    public static void setearValoresIniciales() {
	PersistirVentana.agregarVentanasNuevas();
	PersistirPerfil.agregarPerfilesNuevos();
    }

}