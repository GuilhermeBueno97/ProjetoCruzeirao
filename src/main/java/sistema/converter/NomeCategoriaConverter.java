package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Categoria;
import sistema.service.CategoriaService;

@FacesConverter(forClass=Categoria.class, value="catConverter")
public class NomeCategoriaConverter implements Converter{
	
	private CategoriaService service = new CategoriaService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeCat) {
		
		if(nomeCat != null && !nomeCat.isEmpty()){
			
			for(Categoria u : service.getCategorias())
				if(u.getNome().equals(nomeCat))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoCat) {
		if(objetoCat == null || objetoCat.equals("")){
			return null;
		} else {
			return ((Categoria)objetoCat).getNome();
		}
	}
}
