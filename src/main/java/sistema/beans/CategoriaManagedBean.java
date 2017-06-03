package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Categoria;
import sistema.modelos.Inscricao;
import sistema.modelos.Time;
import sistema.service.CategoriaService;
import sistema.service.InscricaoService;
import sistema.service.TimeService;

@ManagedBean(name="mbCategoria")
@SessionScoped
public class CategoriaManagedBean {
	private Categoria categoria = new Categoria();
	private CategoriaService service = new CategoriaService();
	private Time time = new Time();
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscService = new InscricaoService();
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String salvar(){
		service.salvar(categoria);
		categoria = new Categoria();
		return "inicio";
	}
	
	public ArrayList<Inscricao> getInscricoes(){
		return time.getInscricoes();
	}

	public List<Categoria> getCategorias(){
		return service.getCategorias();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public ArrayList<Time> getAllTeams(){
		
		TimeService ts = new TimeService();
		List<Time> times = ts.getTimes();
		ArrayList<Time> times2 = new ArrayList<Time>();
		times2.addAll(times);
			
		
		return times2;
	}
	
	public void setPagamento(Time t)
	{
		inscricao.setPagamento(true);
		
		t.addInscricao(inscricao);
		
	}
}
