package sistema.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.dao.UsuarioDAO;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Time;
import sistema.modelos.Usuario;
import sistema.service.CampeonatoService;
import sistema.service.TimeService;

@ManagedBean(name="mbInsc")
@SessionScoped
public class InscricaoManagedBean {
	
	private List<Time> times = new ArrayList<Time>();
	private Time timeAtual = new Time();
	private Campeonato campAtual = new Campeonato();
	private Categoria catAtual = new Categoria();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private CampeonatoService campService = new CampeonatoService();
	private Usuario usuarioAtual = new Usuario();
	private UsuarioDAO user = new UsuarioDAO();
	private TimeService timeService = new TimeService();
	
	public Time getTimeAtual() {
		return timeAtual;
	}
	public void setTimeAtual(Time time) {
		this.timeAtual = time;
	}
	public Campeonato getCampAtual() {
		return campAtual;
	}
	public void setCampAtual(Campeonato campAtual) {
		this.campAtual = campAtual;
	}
	public CampeonatoService getCampService() {
		return campService;
	}
	public void setCampService(CampeonatoService campService) {
		this.campService = campService;
	}
	public Categoria getCatAtual() {
		return catAtual;
	}
	public void setCatAtual(Categoria catAtual) {
		this.catAtual = catAtual;
	}
	public List<Campeonato> getCampeonatos() {
		return campService.getCampeonatos();
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public List<Time> getTimes() {
		usuarioAtual = user.pesquisarPorUsername(usuarioAtual.getUserAtual());
		
		times = timeService.getTimes();
		
		for(Time t : times)
		{
			if(t.getDiretor().getNome() != usuarioAtual.getNome())
			{
				times.remove(t);
			}
		}
		
		return times;
	}
	
	public void updateCategories()
	{
		categorias = campAtual.getCategorias();
	}
	public String salvar(){
		
		
		return "inicio";
	}
}
