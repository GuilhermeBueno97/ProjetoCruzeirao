package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.dao.UsuarioDAO;
import sistema.modelos.Papel;
import sistema.modelos.Time;
import sistema.modelos.Usuario;
import sistema.service.TimeService;
import sistema.service.UsuarioService;

@ManagedBean(name="mbTime")
@SessionScoped
public class TimeManagedBean {
	private Time time = new Time();
	private TimeService timeService = new TimeService();
	private Usuario usuarioAtual = new Usuario();
	private UsuarioDAO user = new UsuarioDAO();
	private UsuarioService usuarioService = new UsuarioService();
	
	public String salvar(){
		usuarioAtual = user.pesquisarPorUsername(usuarioAtual.getUserAtual());
		time.setDiretor(usuarioAtual);
		usuarioAtual.setPapel(Papel.DIRETOR);
		timeService.salvar(time);
		usuarioService.salvarEditado(usuarioAtual);
		time = new Time();
		
		return "inicio";
	}

	public List<Time> getTimes(){
		return timeService.getTimes();
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	public void remove(Time time) {
		timeService.remove(time);
	}
}
