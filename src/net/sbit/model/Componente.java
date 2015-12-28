package net.sbit.model;// default package
// Generated 20/12/2015 17:00:03 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Componente generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "componente", catalog = "generalDB")
public class Componente implements java.io.Serializable {

    private String nombreComponente;

    public Componente() {
    }

    public Componente(String nombreComponente) {
	this.nombreComponente = nombreComponente;
    }

    @Id

    @Column(name = "nombre_componente", unique = true, nullable = false, length = 40)
    public String getNombreComponente() {
	return this.nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
	this.nombreComponente = nombreComponente;
    }

}