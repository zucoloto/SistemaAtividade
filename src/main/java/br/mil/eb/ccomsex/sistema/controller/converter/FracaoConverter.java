package br.mil.eb.ccomsex.sistema.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.mil.eb.ccomsex.sistema.model.entity.Fracao;
import br.mil.eb.ccomsex.sistema.model.repository.Fracoes;
import br.mil.eb.ccomsex.sistema.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Fracao.class)
public class FracaoConverter implements Converter {

	// @Inject (não funciona na classe converter)

	private Fracoes fracoes;

	public FracaoConverter() {
		fracoes = CDIServiceLocator.getBean(Fracoes.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Fracao retorno = null;

		if (value != null && !value.equals("")) {
			retorno = fracoes.buscarPorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long id = ((Fracao) value).getId();
			return id == null ? "" : id.toString();
		}

		return null;
	}

}
