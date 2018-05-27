package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import model.Municipios;
import util.HibernateUtil;

@FacesConverter(value = "municipioConverter")

public class MunicipioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String codigo) {
		if (codigo != null && codigo.isEmpty()) {
			try {
				return (Municipios) HibernateUtil.getSessionFactory().getCurrentSession().get(Municipios.class,
						new Integer(codigo));
			} catch (Exception e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		} else {
			return null;
		}

	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			Municipios mun = (Municipios) object;
			return mun.getIdmunicipio() != null && mun.getIdmunicipio() > 0 ? mun.getIdmunicipio().toString() : null;
		} else {
			return null;
		}
	}

}