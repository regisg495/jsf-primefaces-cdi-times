package br.com.times.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "CPFConverter")
public class CPFConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		if(valor != null || valor != "") {
			valor = valor.toString().replaceAll("[- /.]", "");
			valor = valor.toString().replaceAll("[-()]", "");
		}
		return valor;
	}

	public String getAsString(FacesContext context, UIComponent component, Object valor) {
		return valor.toString();
	}

}
