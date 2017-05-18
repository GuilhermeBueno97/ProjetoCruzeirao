package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Time;
import sistema.service.TimeService;

@ManagedBean(name="mbTime")
@SessionScoped
public class TimeManagedBean {
	private Time time = new Time();
	private TimeService service = new TimeService();
	
	public String salvar(){
		service.salvar(time);
		time = new Time();
		return "inicio";
	}

	public List<Time> getTimes(){
		return service.getTimes();
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
