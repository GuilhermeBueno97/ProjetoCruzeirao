package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Usuario;
import sistema.service.UsuarioService;

@ManagedBean(name="mbUser")
@SessionScoped
public class UsuarioManagedBean {
	private Usuario usuario = new Usuario();
	private UsuarioService service = new UsuarioService();
	
	public String salvar(){
		service.salvar(usuario);
		usuario = new Usuario();
		return "welcome";
	}
	
	public List<Usuario> getUsuarios(){
		return service.getUsuarios();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
