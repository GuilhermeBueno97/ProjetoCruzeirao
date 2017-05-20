package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.dao.UsuarioDAO;
import sistema.modelos.Time;
import sistema.modelos.Usuario;
import sistema.service.TimeService;

@ManagedBean(name="mbTime")
@SessionScoped
public class TimeManagedBean {
	private Time time = new Time();
	private TimeService service = new TimeService();
	private Usuario usuarioAtual = new Usuario();
	private UsuarioDAO user = new UsuarioDAO();
	
	public String salvar(){
		usuarioAtual = user.pesquisarPorUsername(usuarioAtual.getUserAtual());
		time.setDiretor(usuarioAtual);
		service.salvar(time);
		time = new Time();
		
		return "inicio";
	}

	public List<Time> getTimes(){
		return service.getTimes();
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
