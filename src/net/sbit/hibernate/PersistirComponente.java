package net.sbit.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import net.sbit.model.Componente;

public class PersistirComponente {

    public static void nuevo(String nombreComponente) {

	Session session = HibernateUtil.getSessionFactory().openSession();
	try {

	    session.beginTransaction();
	    session.save(new Componente(nombreComponente));
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    public static void borrar(Componente componente) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Componente componenteABorrar = (Componente) session.get(Componente.class, componente.getNombreComponente());
	    session.delete(componenteABorrar);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    public static void update(Componente componente) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Componente componetneActualizado = (Componente) session.get(Componente.class,
		    componente.getNombreComponente());
	    componetneActualizado.setNombreComponente(componente.getNombreComponente());
	    session.update(componetneActualizado);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    @SuppressWarnings({ "unchecked" })
    public static Boolean existeComponente(String nombreComponente) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Boolean existe = false;
	try {
	    session.beginTransaction();
	    List<Componente> listaComponente = session.createQuery("FROM Componente").list();
	    if (!listaComponente.isEmpty()) {
		for (int i = 0; i < listaComponente.size(); i++) {
		    if (nombreComponente.equals(listaComponente.get(i).getNombreComponente())) {
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
    public static List<Componente> obtenerListaComponentes() {
	List<Componente> componentes = new ArrayList<Componente>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    componentes = session.createQuery("FROM Componente").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return componentes;
    }

}
