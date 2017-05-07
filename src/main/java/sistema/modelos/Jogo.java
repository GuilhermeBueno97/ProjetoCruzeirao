package sistema.modelos;

import java.util.Date;

public class Jogo {
	private Date data;
	private Time timeA;
	private Time timeB;
	private Local local;
	private Usuario arbitro;
	private Relatorio relatorio;
	private Jogo prox_jogo;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getTimeA() {
		return timeA;
	}
	public void setTimeA(Time timeA) {
		this.timeA = timeA;
	}
	public Time getTimeB() {
		return timeB;
	}
	public void setTimeB(Time timeB) {
		this.timeB = timeB;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Usuario getArbitro() {
		return arbitro;
	}
	public void setArbitro(Usuario arbitro) {
		this.arbitro = arbitro;
	}
	public Relatorio getRelatorio() {
		return relatorio;
	}
	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}
	public Jogo getProx_jogo() {
		return prox_jogo;
	}
	public void setProx_jogo(Jogo prox_jogo) {
		this.prox_jogo = prox_jogo;
	}
}
