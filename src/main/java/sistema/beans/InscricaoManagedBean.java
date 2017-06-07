package sistema.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.dao.UsuarioDAO;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Convite;
import sistema.modelos.Inscricao;
import sistema.modelos.Papel;
import sistema.modelos.Time;
import sistema.modelos.Usuario;
import sistema.service.CampeonatoService;
import sistema.service.ConviteService;
import sistema.service.InscricaoService;
import sistema.service.TimeService;
import sistema.service.UsuarioService;

@ManagedBean(name = "mbInsc")
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
	private Convite convite = new Convite();
	private ConviteService convService = new ConviteService();
	private List<Convite> convites = new ArrayList<Convite>();
	private Calendar data_cal = Calendar.getInstance();

	public String salvar() {
		inscricao.setTime(timeAtual);
		inscricao.setCategoria(catAtual);
		inscricao.getCategoria().setCampeonato(campAtual);

		inscService.salvar(inscricao);

		timeAtual.addInscricao(inscricao);
		timeService.salvarEditado(timeAtual);

		for (Usuario u : usuariosList) {
			convite.setInscricao(inscricao);
			convite.setUser(u);
			convite.setData(data_cal);
			u.addConvite(convite);
			convService.salvar(convite);
			userService.salvarEditado(u);
			convite = new Convite();
		}

		return "inicio";
	}

	public ArrayList<Usuario> getUsuariosList() {
		return usuariosList;
	}

	public List<Inscricao> getInscricoes() {
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

		for (Time t : times) {
			if (t.getDiretor().getUsername() != usuarioAtual.getUsername()) {
				times.remove(t);
			}
		}

		return times;
	}

	public List<Convite> getConvitesUsuarioAtual() {
		usuarioAtual = user.pesquisarPorUsername(usuarioAtual.getUserAtual());
		return usuarioAtual.getConvites();
	}

	public List<Inscricao> getAllInscricoes() {
		/*List<Time> times = timeService.getTimes();
		HashSet<Time> timesNaoInscritos = new HashSet<Time>();
		List<Time> listaTimes = new ArrayList<Time>();

		for (Time t : times) {
			for (Inscricao i : t.getInscricoes()) {
				if (!i.isValidada() && !i.getPagamento()) {
					timesNaoInscritos.add(i.getTime());
				}
			}
		}

		Iterator<Time> i = timesNaoInscritos.iterator();

		while (i.hasNext()) {
			listaTimes.add(i.next());
		}
		return listaTimes;*/

		HashSet<Inscricao> inscNotValidated = new HashSet<Inscricao>();
		List<Inscricao> inscricoes = inscService.getInscricoes();
		List<Inscricao> listaInscricoes = new ArrayList<Inscricao>();
		
		for(Inscricao i : inscricoes)
		{
			if (!i.isValidada() && !i.getPagamento()) {
				inscNotValidated.add(i);
			}
		}
		
		Iterator<Inscricao> i = inscNotValidated.iterator();

		while (i.hasNext()) {
			listaInscricoes.add(i.next());
		}
		
		return listaInscricoes;
	}

	public List<Inscricao> getInscricoesValidadas() {
		List<Inscricao> inscricoes = new ArrayList<Inscricao>();

		for (Inscricao i : inscService.getInscricoes()) {
			if (i.isValidada() && i.getPagamento()) {
				inscricoes.add(i);
			}
		}

		return inscricoes;
	}

	public void updateCategories() {
		categorias = campAtual.getCategorias();
	}

	public List<Usuario> getUsuarios() {
		return userService.getUsuarios();
	}

	public void remove(Inscricao inscricao) {
		
		Time t = null;
		
		for (Inscricao i : inscService.getInscricoes()) {
			if(i.getTime() == inscricao.getTime())
			{
				t = i.getTime();
			}
		}
		
		t.removeInscricao(inscricao);
		timeService.salvarEditado(t);
		inscService.remove(inscricao);
	}

	public void autorizar(Inscricao inscricao) {

		inscricao.setPagamento(true);
		inscricao.setValidada(true);

		inscService.salvarEditado(inscricao);
	}

	public void removeConvite(Convite convite) {
		Usuario user = convite.getUser();

		for (Convite c : convite.getUser().getConvites()) {
			if (c == convite) {
				user.removeConvite(c);
				break;
			}
		}
		
		userService.salvarEditado(user);
		convService.remove(convite);
	}

	public void autorizarConvite(Convite c) {
		Inscricao inscricao = c.getInscricao();
		Usuario user = c.getUser();

		user.setPapel(Papel.JOGADOR);
		inscricao.addJogador(user);
		user.removeConvite(c);

		inscService.salvarEditado(inscricao);
		userService.salvarEditado(user);
		convService.remove(c);
	}

	public List<Usuario> getTodosMenosDiretor() {
		List<Usuario> users = userService.getUsuarios();
		usuarioAtual = user.pesquisarPorUsername(usuarioAtual.getUserAtual());
		Usuario aux = null;

		for (Usuario u : users) {
			if (u.getUsername() == usuarioAtual.getUsername())
				// users.remove(u);
				aux = u;
		}

		users.remove(aux);
		return users;
	}

	public List<Convite> getConvites() {
		return convites;
	}

	public void setConvites(List<Convite> convites) {
		this.convites = convites;
	}

}
