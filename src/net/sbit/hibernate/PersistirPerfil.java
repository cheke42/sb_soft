package net.sbit.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import net.sbit.model.Perfil;

public class PersistirPerfil {

    public static void nuevo(String nombrePerfil, Boolean estado) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    session.save(new Perfil(nombrePerfil, estado));
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    public static void borrar(Perfil perfil) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Perfil PerfilABorrar = (Perfil) session.get(Perfil.class, perfil.getNombrePerfil());
	    session.delete(PerfilABorrar);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    public static void update(Perfil perfil) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Perfil perfiActualizado = (Perfil) session.get(Perfil.class, perfil.getNombrePerfil());
	    perfiActualizado.setNombrePerfil(perfil.getNombrePerfil());
	    perfiActualizado.setEstadoPerfil(perfil.getEstadoPerfil());
	    session.update(perfiActualizado);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    @SuppressWarnings({ "unchecked" })
    public static Boolean existePerfil(String nombrePerfil) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Boolean existe = false;
	try {
	    session.beginTransaction();
	    List<Perfil> listaPerfil = session.createQuery("FROM Perfil").list();
	    if (!listaPerfil.isEmpty()) {
		for (int i = 0; i < listaPerfil.size(); i++) {
		    if (nombrePerfil.equals(listaPerfil.get(i).getNombrePerfil())) {
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
    public static List<Perfil> obtenerListaPerfil() {
	List<Perfil> perfiles = new ArrayList<Perfil>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    perfiles = session.createQuery("FROM Perfil").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return perfiles;
    }

}
