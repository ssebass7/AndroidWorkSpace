package com.example.ejercicio_xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "muni", strict = false)
public class Municipio {
	@Element(name = "nm")
	private String nombre;
	@Element(name = "loine")
	private Loine loine;

	public Municipio() {
		super();
	}

	public Municipio(String nombre, Loine loine) {
		this.nombre = nombre;
		this.loine = loine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Loine getLoine() {
		return loine;
	}

	public void setLoine(Loine loine) {
		this.loine = loine;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
