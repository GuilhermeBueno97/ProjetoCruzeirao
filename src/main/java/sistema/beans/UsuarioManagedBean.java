package sistema.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Papel;
import sistema.modelos.Usuario;
import sistema.service.UsuarioService;

@ManagedBean(name = "mbUser")
@SessionScoped
public class UsuarioManagedBean {
	private Usuario usuario = new Usuario();
	private UsuarioService service = new UsuarioService();
	private Date data;
	private Calendar data_cal = new GregorianCalendar();

	public String salvar() {

		data_cal.setTime(data);
		usuario.setData_nasc(data_cal);

		usuario.setPapel(Papel.COMUM);
		service.salvar(usuario);
		usuario = new Usuario();
		return "welcome";
	}

	public Boolean Cu() {
		Usuario usuarioAtual = new Usuario();
		String name = usuarioAtual.getUserAtual();
		usuarioAtual = service.getUsuarioAtual(name);

		if (usuarioAtual.getPapel().toString() == Papel.DIRETOR.toString())
			return true;

		return false;
	}

	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
