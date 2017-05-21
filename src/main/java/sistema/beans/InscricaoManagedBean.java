package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.service.CampeonatoService;
import sistema.service.CategoriaService;

@ManagedBean(name="mbInsc")
@SessionScoped
public class InscricaoManagedBean {
	
	private Campeonato campAtual = new Campeonato();
	private Categoria catAtual = new Categoria();
	private ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private CampeonatoService campService = new CampeonatoService();
	private CategoriaService catService = new CategoriaService();
	
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
	public void setCampeonatos(ArrayList<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
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
		return categorias = catService.getCategoriasCamp(campAtual);
	}
	
}
