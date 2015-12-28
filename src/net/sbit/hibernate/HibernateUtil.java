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

    public static SessionFactory getSessionFactory() {

	return sessionFactory;
    }

    // @SuppressWarnings("unchecked")
    // public static List<PerfilVentanaPermiso> obtenerListaTickets() {
    // List<PerfilVentanaPermiso> tickets = new
    // ArrayList<PerfilVentanaPermiso>();
    // Session session = HibernateUtil.getSessionFactory().openSession();
    // try {
    // session.beginTransaction();
    // tickets = session.createQuery("FROM PerfilVentanaPermiso").list();
    // } catch (Exception e) {
    // e.printStackTrace();
    // } finally {
    // session.flush();
    // session.close();
    // }
    // return tickets;
    // }

//    public static void guardarComplejo() {
//	Session session = HibernateUtil.getSessionFactory().openSession();
//	try {
//
//	    session.beginTransaction();
//	    Perfil perfil = new Perfil("desarrollador", true);
//	    session.save(perfil);
//	    Ventana ventana = new Ventana("lista_usuarios");
//	    session.save(ventana);
//	    Permiso permiso = new Permiso(4, "button_cancelar");
//	    session.save(permiso);
//	    VentanaPermisoId ventanaPermiso = new VentanaPermisoId(ventana.getNombre(), permiso.getIdpermiso());
//	    VentanaPermiso vp = new VentanaPermiso(ventanaPermiso);
//	    session.save(vp);
//	    PerfilVentanaPermisoId perfilVentanaPermisoId = new PerfilVentanaPermisoId(perfil.getNombre(),
//		    ventana.getNombre(), permiso.getIdpermiso());
//	    PerfilVentanaPermiso pvp = new PerfilVentanaPermiso(perfilVentanaPermisoId);
//	    session.save(pvp);
//	    pvp.setEstado(false);
//	    session.getTransaction().commit();
//	} catch (Exception e) {
//	    e.printStackTrace();
//	} finally {
//	    session.flush();
//	    session.close();
//	}
//    }

//    @SuppressWarnings("finally")
//    public static Boolean estadoPerfilPermisoVentana(String nombrePerfil, String nombreVentana, int idPermiso) {
//	Session session = HibernateUtil.getSessionFactory().openSession();
//	Boolean estado = false;
//	try {
//
//	    session.beginTransaction();
//	    PerfilVentanaPermiso pvp = (PerfilVentanaPermiso) session.get(PerfilVentanaPermiso.class,
//		    new PerfilVentanaPermisoId(nombrePerfil, nombreVentana, idPermiso));
//	    estado = pvp.getEstado();
//	    session.getTransaction().commit();
//	} catch (Exception e) {
//	    e.printStackTrace();
//	} finally {
//	    session.flush();
//	    session.close();
//	    return estado;
//	}
//    }

}