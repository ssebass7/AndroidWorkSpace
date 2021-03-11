package com.example.ejercicio_xml;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "consulta_provinciero", strict = false)
public class Provinciero {
	@ElementList(name = "provinciero")
	private List<Provincia> provincias;

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
}
