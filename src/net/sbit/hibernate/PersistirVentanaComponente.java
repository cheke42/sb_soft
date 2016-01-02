package net.sbit.hibernate;

import org.hibernate.Session;

import net.sbit.model.Componente;
import net.sbit.model.Ventana;
import net.sbit.model.VentanaComponente;
import net.sbit.model.VentanaComponenteId;

public class PersistirVentanaComponente {
    
    public static void nueva(String ventana, String componente) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Componente comp = (Componente) session.get(Componente.class, componente);
	    Ventana vtn = (Ventana) session.get(Ventana.class, ventana);
	    VentanaComponenteId vcid = new VentanaComponenteId(comp.getNombreComponente(), vtn.getNombreVentana());
	    VentanaComponente vc = new VentanaComponente(vcid);
	    session.save(vc);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }
    
    public static void borrar(String ventana, String componente){
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    Componente comp = (Componente) session.get(Componente.class, componente);
	    Ventana vtn = (Ventana) session.get(Ventana.class, ventana);
	    VentanaComponenteId vcid = new VentanaComponenteId(comp.getNombreComponente(), vtn.getNombreVentana());
	    VentanaComponente vc = new VentanaComponente(vcid);
	    session.delete(vc);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
    }
}
