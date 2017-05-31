package sistema.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Local;
import sistema.service.LocalService;

@ManagedBean(name="mbLocal")
@SessionScoped
public class LocalManagedBean {
	
	private Local local = new Local();
	private LocalService service = new LocalService();
	
	public String salvar(){
		service.salvar(local);
		local = new Local();
		
		return "inicio";
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
