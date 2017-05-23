package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Usuario;
import sistema.service.UsuarioService;

@FacesConverter(forClass=Usuario.class, value="userConverter")
public class NomeUsuarioConverter implements Converter{
	
	private UsuarioService service = new UsuarioService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeUser) {
		
		if(nomeUser != null && !nomeUser.isEmpty()){
			
			for(Usuario u : service.getUsuarios())
				if(u.getNome().equals(nomeUser))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoUser) {
		if(objetoUser == null || objetoUser.equals("")){
			return null;
		} else {
			return ((Usuario)objetoUser).getNome();
		}
	}
}
