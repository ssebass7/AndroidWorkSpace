package com.example.ejercicio_xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "loine")
public class Loine {
	@Element(name = "cp")
	private String codigo_provincia;
	@Element(name = "cm")
	private String codigo_municipio;

	public Loine() {
		super();
	}

	public Loine(String codigo_provincia, String codigo_municipio) {
		this.codigo_provincia = codigo_provincia;
		this.codigo_municipio = codigo_municipio;
	}

	public String getCodigo_provincia() {
		return codigo_provincia;
	}

	public void setCodigo_provincia(String codigo_provincia) {
		this.codigo_provincia = codigo_provincia;
	}

	public String getCodigo_municipio() {
		return codigo_municipio;
	}

	public void setCodigo_municipio(String codigo_municipio) {
		this.codigo_municipio = codigo_municipio;
	}

	@Override
	public String toString() {
		return codigo_provincia + " -- " + codigo_municipio;
	}

}
