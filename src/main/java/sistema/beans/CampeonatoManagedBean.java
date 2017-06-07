package sistema.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import sistema.dao.UsuarioDAO;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.modelos.Papel;
import sistema.modelos.Usuario;
import sistema.service.CampeonatoService;
import sistema.service.CategoriaService;
import sistema.service.UsuarioService;

@ManagedBean(name = "mbCampeonato")
@SessionScoped
public class CampeonatoManagedBean {
	private Campeonato campeonato = new Campeonato();
	private CampeonatoService campService = new CampeonatoService();
	private CategoriaService catService = new CategoriaService();
	private Categoria categoria = new Categoria();
	private Date data_inicio;
	private Date data_fim;
	private Date data_insc_inicio;
	private Date data_insc_fim;
	private Calendar inicio_cal = new GregorianCalendar();
	private Calendar fim_cal = new GregorianCalendar();
	private Calendar inicio_insc_cal = new GregorianCalendar();
	private Calendar fim_insc_cal = new GregorianCalendar();
	private Usuario usuarioAtual = new Usuario();
	private UsuarioDAO userDAO = new UsuarioDAO();
	private UsuarioService userService = new UsuarioService();

	public String salvar() {
		inicio_cal.setTime(data_inicio);
		fim_cal.setTime(data_fim);
		inicio_insc_cal.setTime(data_insc_inicio);
		fim_insc_cal.setTime(data_insc_fim);

		campeonato.setData_inicio(inicio_cal);
		campeonato.setData_fim(fim_cal);
		campeonato.setData_insc_inicio(inicio_insc_cal);
		campeonato.setData_insc_fim(fim_insc_cal);

		usuarioAtual = userDAO.pesquisarPorUsername(usuarioAtual.getUserAtual());
		usuarioAtual.setPapel(Papel.ORGANIZADOR);

		userService.salvarEditado(usuarioAtual);
		catService.salvar(categoria);
		campeonato.addCategorias(categoria);
		campService.salvar(campeonato);
		campeonato = new Campeonato();
		categoria = new Categoria();
		return "inicio";
	}

	public String salvarNewCategoria() {
		catService.salvar(categoria);
		campeonato.addCategorias(categoria);
		categoria = new Categoria();
		return "cadastroCategoria";
	}

	public List<Campeonato> getCampeonatos() {
		return campService.getCampeonatos();
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public Date getData_insc_inicio() {
		return data_insc_inicio;
	}

	public void setData_insc_inicio(Date data_insc_inicio) {
		this.data_insc_inicio = data_insc_inicio;
	}

	public Date getData_insc_fim() {
		return data_insc_fim;
	}

	public void setData_insc_fim(Date data_insc_fim) {
		this.data_insc_fim = data_insc_fim;
	}

}
