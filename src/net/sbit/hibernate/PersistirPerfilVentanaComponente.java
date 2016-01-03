package net.sbit.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import net.sbit.model.Componente;
import net.sbit.model.Perfil;
import net.sbit.model.PerfilVentanaComponente;
import net.sbit.model.PerfilVentanaComponenteId;
import net.sbit.model.Ventana;

public class PersistirPerfilVentanaComponente {

    /*
     * NUEVO: crear una nueva visibilidad para un componente de una ventana de
     * un determinado perfil
     */
    public static void nuevo(String perfil, String ventana, String componente, Boolean estado) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Componente comp = (Componente) session.get(Componente.class, componente);
	    Ventana vtn = (Ventana) session.get(Ventana.class, ventana);
	    Perfil pf = (Perfil) session.get(Perfil.class, perfil);

	    PerfilVentanaComponenteId pvcid = new PerfilVentanaComponenteId(pf.getNombrePerfil(),
		    comp.getNombreComponente(), vtn.getNombreVentana());
	    PerfilVentanaComponente pvc = new PerfilVentanaComponente(pvcid);
	    pvc.setEstado(estado);
	    session.save(pvc);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    /*
     * BORRAR: borra una relacion de visibilidad para un componente de una
     * ventana de un determinado perfil
     */
    public static void borrar(String perfil, String ventana, String componente) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Componente comp = (Componente) session.get(Componente.class, componente);
	    Ventana vtn = (Ventana) session.get(Ventana.class, ventana);
	    Perfil pf = (Perfil) session.get(Perfil.class, perfil);

	    PerfilVentanaComponenteId pvcid = new PerfilVentanaComponenteId(pf.getNombrePerfil(),
		    comp.getNombreComponente(), vtn.getNombreVentana());
	    PerfilVentanaComponente pvc = (PerfilVentanaComponente) session.get(PerfilVentanaComponente.class, pvcid);
	    session.delete(pvc);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    /*
     * ACTUALIZAR_ESTADO: actualiza la visibilidad de un componente de una
     * ventana en un determinado perfil
     */
    public static void actualizarEstado(String perfil, String ventana, String componente, Boolean estado) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Componente comp = (Componente) session.get(Componente.class, componente);
	    Ventana vtn = (Ventana) session.get(Ventana.class, ventana);
	    Perfil pf = (Perfil) session.get(Perfil.class, perfil);

	    PerfilVentanaComponenteId pvcid = new PerfilVentanaComponenteId(pf.getNombrePerfil(),
		    comp.getNombreComponente(), vtn.getNombreVentana());
	    PerfilVentanaComponente pvc = (PerfilVentanaComponente) session.get(PerfilVentanaComponente.class, pvcid);
	    pvc.setEstado(estado);
	    session.update(pvc);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }

    @SuppressWarnings("unchecked")
    /*
     * OBTENER_VENTANA_Y_COMPONENTE_DE_UN_PERFIL: Devuele una lista con todos
     * los componentes de todas las ventanas de un determinado perfil junto con
     * su visibilidad
     */
    public static List<PerfilVentanaComponente> obtenerVentanayComponentesDeUnPerfil(String perfil) {
	List<PerfilVentanaComponente> lista = new ArrayList<PerfilVentanaComponente>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    lista = session.createQuery("FROM PerfilVentanaComponente WHERE nom_per_vpc = '" + perfil + "'").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return lista;
    }

}
