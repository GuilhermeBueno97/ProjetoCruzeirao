package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Time;
import sistema.service.TimeService;

@FacesConverter(forClass=Time.class, value="timeConverter")
public class NomeTimeConverter implements Converter{
	
	private TimeService service = new TimeService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeTime) {
		
		if(nomeTime != null && !nomeTime.isEmpty()){
			
			for(Time u : service.getTimes())
				if(u.getNome().equals(nomeTime))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoTime) {
		if(objetoTime == null || objetoTime.equals("")){
			return null;
		} else {
			return ((Time)objetoTime).getNome();
		}
	}
}
