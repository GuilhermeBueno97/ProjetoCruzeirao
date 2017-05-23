package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

import sistema.dao.UsuarioDAO;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Inscricao;
import sistema.modelos.Time;
import sistema.modelos.Usuario;
import sistema.service.CampeonatoService;
import sistema.service.CategoriaService;
import sistema.service.InscricaoService;
import sistema.service.TimeService;
import sistema.service.UsuarioService;

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
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscService = new InscricaoService();
	private UsuarioService userService = new UsuarioService();
	private ArrayList<Usuario> usuariosList = new ArrayList<Usuario>();
	private CategoriaService catService = new CategoriaService();
	
	public String salvar(){
		inscricao.setTime(timeAtual);
		inscricao.setCategoria(catAtual);
		inscricao.getCategoria().setCampeonato(campAtual);
		inscricao.setJogadores(usuariosList);
		
		inscService.salvar(inscricao);
		
		timeAtual.addInscricao(inscricao);
		timeService.salvarEditado(timeAtual);
		
		return "inicio";
	}
	public ArrayList<Usuario> getUsuariosList() {
		return usuariosList;
	}
	public List<Inscricao> getInscricoes(){
		return inscService.getInscricoes();
	}
	public void setUsuariosList(ArrayList<Usuario> usuariosList) {
		this.usuariosList = usuariosList;
	}
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
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}
	public void setUsuarioAtual(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}
	public List<Time> getTimesUsuarioAtual() {
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
	
	public List<Usuario> getUsuarios(){
		return userService.getUsuarios();
	}
}