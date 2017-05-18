package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.dao.UsuarioDAO;
import sistema.modelos.Usuario;
import sistema.service.UsuarioService;

@FacesConverter(forClass=Usuario.class, value="usuarioConverter")
public class NomeUsuarioConverter implements Converter{
	
	private UsuarioService service = new UsuarioService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String nomeUsuario) {
		
		if(nomeUsuario != null && !nomeUsuario.isEmpty()){
			
			for(Usuario u : service.getUsuarios())
				if(u.getNome().equals(nomeUsuario))
					return u;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objetoUsuario) {
		if(objetoUsuario == null || objetoUsuario.equals("")){
			return null;
		} else {
			return ((Usuario) objetoUsuario).getNome();
		}
	}
}
