//package converter;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.ConverterException;
//
//import model.Municipios;
//import util.HibernateUtil;
//
//FacesConverter(value="municipioConverter")
//
//public class MunicipioConverter implements Converter {
//
//	@Override
//	public Object getAsObject(FacesContext fc, UIComponent uic, String codigo) {
//		if (codigo != null && codigo.isEmpty()) {
//			try {
//				return (Municipios) HibernateUtil.getSessionFactory().getCurrentSession().get(Municipios.class,
//						new Integer(codigo));
//			} catch (Exception e) {
//				throw new ConverterException(
//						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
//			}
//		} else {
//			return null;
//		}
//		return codigo;
//	}
//
//	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
//		if (object != null) {
//			Municipio mun = (Municipios) object;
//			return municipio.getIdmunicipio() != null && municipio.getIdmunicipio() > 0
//					? municipio.getIdmunicipio().toString()
//					: null;
//		} else {
//			return null;
//		}
//	}
//
//}