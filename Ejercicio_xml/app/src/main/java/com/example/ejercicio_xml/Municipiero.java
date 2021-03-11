package com.example.ejercicio_xml;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "consulta_municipiero", strict = false)
public class Municipiero {
	@ElementList(name = "municipiero")
	private List<Municipio> municipios;

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

}
