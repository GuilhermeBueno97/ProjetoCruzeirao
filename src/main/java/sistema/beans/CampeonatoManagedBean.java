package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.service.CampeonatoService;
import sistema.service.CategoriaService;

@ManagedBean(name="mbCampeonato")
@SessionScoped
public class CampeonatoManagedBean {
	private Campeonato campeonato = new Campeonato();
	private CampeonatoService campService = new CampeonatoService();
	private CategoriaService catService = new CategoriaService();
	private Categoria categoria = new Categoria();
	
	public String salvar(){
		catService.salvar(categoria);
		campeonato.addCategorias(categoria);
		campService.salvar(campeonato);
		campeonato = new Campeonato();
		categoria = new Categoria();
		return "inicio";
	}
	
	public String salvarNewCategoria(){
		catService.salvar(categoria);
		campeonato.addCategorias(categoria);
		categoria = new Categoria();
		return "cadastroCategoria";
	}
	
	public List<Campeonato> getCampeonatos(){
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
}
