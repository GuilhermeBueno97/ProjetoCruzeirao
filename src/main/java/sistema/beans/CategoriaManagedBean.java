package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Categoria;
import sistema.modelos.Time;
import sistema.service.CategoriaService;

@ManagedBean(name="mbCategoria")
@SessionScoped
public class CategoriaManagedBean {
	private Categoria categoria = new Categoria();
	private CategoriaService service = new CategoriaService();
	private Time time = new Time();
	
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
		List<Categoria> list = service.getCategorias();
		ArrayList<Time> allTeams = new ArrayList<Time>();
		for(Categoria cat : list)
		{
			ArrayList<Time> times = new ArrayList<Time>();
			
			times = cat.getTimes();
			
			for(Time team : times)
			{
				allTeams.add(team);
			}
		}
		
		return allTeams;
	}
	
	public void setPagamento(Time t)
	{
		
	}
}
