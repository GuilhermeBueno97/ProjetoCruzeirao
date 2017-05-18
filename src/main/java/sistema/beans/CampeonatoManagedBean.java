package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Campeonato;
import sistema.service.CampeonatoService;

@ManagedBean(name="mbCampeonato")
@SessionScoped
public class CampeonatoManagedBean {
	private Campeonato campeonato = new Campeonato();
	private CampeonatoService service = new CampeonatoService();
	
	public String salvar(){
		service.salvar(campeonato);
		campeonato = new Campeonato();
		return "cadastroCategoria";
	}

	public List<Campeonato> getCampeonatos(){
		return service.getCampeonatos();
	}
	
	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
}
