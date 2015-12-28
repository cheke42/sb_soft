package net.sbit.property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("restriction")
public class ComponenteProperty {

    private final StringProperty nombreComponente;

    public ComponenteProperty(String nombreComponente) {

	this.nombreComponente = new SimpleStringProperty(nombreComponente);

    }

    public StringProperty getComponente() {
	return nombreComponente;
    }

    public void setComponente(String pasajero) {
	this.nombreComponente.set(pasajero);
    }

    public StringProperty componenteProperty() {
	return nombreComponente;
    }

}
