package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Inscricao;
import sistema.service.InscricaoService;

@FacesConverter(forClass=Inscricao.class, value="inscConverter")
public class NomeInscricaoConverter implements Converter{
	
	private InscricaoService service = new InscricaoService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeInscricao) {
		
		if(nomeInscricao != null && !nomeInscricao.isEmpty()){
			
			for(Inscricao u : service.getInscricoes())
				if(u.getCategoria().getCampeonato().getNome().equals(nomeInscricao))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoInscricao) {
		if(objetoInscricao == null || objetoInscricao.equals("")){
			return null;
		} else {
			return ((Inscricao)objetoInscricao).getCategoria().getNome();
		}
	}
}
