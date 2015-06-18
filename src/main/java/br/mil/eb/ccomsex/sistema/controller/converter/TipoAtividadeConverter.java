package br.mil.eb.ccomsex.sistema.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mil.eb.ccomsex.sistema.model.entity.TipoAtividade;
import br.mil.eb.ccomsex.sistema.model.repository.TipoAtividadeRepository;

@FacesConverter(forClass = TipoAtividade.class)
public class TipoAtividadeConverter implements Converter {

	@Inject
	private TipoAtividadeRepository tipoAtividadeRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		TipoAtividade retorno = null;
		if (value != null && !value.equals("")) {
			retorno = tipoAtividadeRepository.buscarPorId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			TipoAtividade retorno = (TipoAtividade) value;
			return retorno.getId() == null ? null : retorno.getId().toString();
		}
		return null;
	}

}
