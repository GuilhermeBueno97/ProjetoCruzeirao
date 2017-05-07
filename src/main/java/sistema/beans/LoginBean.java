package sistema.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private AlertaUtil msg = new AlertaUtil();
	
	public void preRender(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if ("true".equals(request.getParameter("error"))) {
			msg.exibirErroGrowl("Usuário ou senha inválidos");
		}
	}
}
