package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Campeonato;
import sistema.service.CampeonatoService;

@FacesConverter(forClass=Campeonato.class, value="campConverter")
public class NomeCampeonatoConverter implements Converter{
	
	private CampeonatoService service = new CampeonatoService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeCamp) {
		
		if(nomeCamp != null && !nomeCamp.isEmpty()){
			
			for(Campeonato u : service.getCampeonatos())
				if(u.getNome().equals(nomeCamp))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoCamp) {
		if(objetoCamp == null || objetoCamp.equals("")){
			return null;
		} else {
			return ((Campeonato)objetoCamp).getNome();
		}
	}
}
