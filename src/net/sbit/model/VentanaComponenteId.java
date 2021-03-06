package net.sbit.model;// default package// default package

// Generated 20/12/2015 17:00:03 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VentanaComponenteId generated by hbm2java
 */
@SuppressWarnings("serial")
@Embeddable
public class VentanaComponenteId implements java.io.Serializable {

    private String nomComponente;
    private String nomVentana;

    public VentanaComponenteId() {
    }

    public VentanaComponenteId(String nomComponente, String nomVentana) {
	this.nomComponente = nomComponente;
	this.nomVentana = nomVentana;
    }

    @Column(name = "nom_componente", nullable = false, length = 40)
    public String getNomComponente() {
	return this.nomComponente;
    }

    public void setNomComponente(String nomComponente) {
	this.nomComponente = nomComponente;
    }

    @Column(name = "nom_ventana", nullable = false, length = 40)
    public String getNomVentana() {
	return this.nomVentana;
    }

    public void setNomVentana(String nomVentana) {
	this.nomVentana = nomVentana;
    }

    public boolean equals(Object other) {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof VentanaComponenteId))
	    return false;
	VentanaComponenteId castOther = (VentanaComponenteId) other;

	return ((this.getNomComponente() == castOther.getNomComponente())
		|| (this.getNomComponente() != null && castOther.getNomComponente() != null
			&& this.getNomComponente().equals(castOther.getNomComponente())))
		&& ((this.getNomVentana() == castOther.getNomVentana())
			|| (this.getNomVentana() != null && castOther.getNomVentana() != null
				&& this.getNomVentana().equals(castOther.getNomVentana())));
    }

    public int hashCode() {
	int result = 17;

	result = 37 * result + (getNomComponente() == null ? 0 : this.getNomComponente().hashCode());
	result = 37 * result + (getNomVentana() == null ? 0 : this.getNomVentana().hashCode());
	return result;
    }

}
