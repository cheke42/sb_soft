package net.sbit.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import net.sbit.enums.TipoVentana;
import net.sbit.model.Ventana;

public class PersistirVentana {

    public static void nuevo(String nombreVentana) {

	Session session = HibernateUtil.getSessionFactory().openSession();
	try {

	    session.beginTransaction();
	    session.save(new Ventana(nombreVentana));
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    public static void borrar(Ventana ventana) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Ventana ventanaABorrar = (Ventana) session.get(Ventana.class, ventana.getNombreVentana());
	    session.delete(ventanaABorrar);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    public static void update(Ventana ventana) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Ventana ventanaAActualizar = (Ventana) session.get(Ventana.class, ventana.getNombreVentana());
	    ventanaAActualizar.setNombreVentana(ventana.getNombreVentana());
	    session.update(ventanaAActualizar);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    @SuppressWarnings({ "unchecked" })
    public static Boolean existeVentana(String nombreVentana) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Boolean existe = false;
	try {
	    session.beginTransaction();
	    List<Ventana> listaVentana = session.createQuery("FROM Ventana").list();
	    if (!listaVentana.isEmpty()) {
		for (int i = 0; i < listaVentana.size(); i++) {
		    if (nombreVentana.equals(listaVentana.get(i).getNombreVentana())) {
			existe = true;
			break;
		    }
		}
	    }
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return existe;
    }

    @SuppressWarnings("unchecked")
    public static List<Ventana> obtenerListaVentanas() {
	List<Ventana> ventanas = new ArrayList<Ventana>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    ventanas = session.createQuery("FROM Ventana").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return ventanas;
    }

    public static void agregarVentanasNuevas() {
	for (TipoVentana tipoVentana : TipoVentana.values()) {
	    if (!existeVentana(tipoVentana.toString())) {
		nuevo(tipoVentana.toString());
	    }
	}
    }

    public static List<?> obtenerListaComponentes(String ventana) {
	List<?> lista = new ArrayList<>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    lista = session.createQuery("FROM VentanaComponente WHERE nom_ventana = '" + ventana + "'").list();
	} catch (Exception e) {
	    // TODO: handle exception
	} finally {
	    session.flush();
	    session.close();
	}
	return lista;
    }
    
    public static void algo(){
	
    }

}
