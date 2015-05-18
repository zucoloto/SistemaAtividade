package br.mil.eb.ccomsex.sistema.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.mil.eb.ccomsex.sistema.model.entity.Grupo;
import br.mil.eb.ccomsex.sistema.model.repository.GrupoRepository;
import br.mil.eb.ccomsex.sistema.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

	// @Inject (não funciona na classe converter)

	private GrupoRepository grupos;

	public GrupoConverter() {
		grupos = CDIServiceLocator.getBean(GrupoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Grupo retorno = null;

		if (value != null && !value.equals("")) {
			retorno = grupos.buscarPorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Grupo grupo = (Grupo) value;
			return grupo.getId() == null ? null : grupo.getId().toString();
		}

		return "";
	}

}
