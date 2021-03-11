package com.example.ejercicio_xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "prov")
public class Provincia {
	@Element(name = "cpine")
	private String codigo;
	@Element(name = "np")
	private String nombre;

	public Provincia() {
		super();
	}

	public Provincia(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
