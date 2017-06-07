package sistema.modelos;


import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="jogos")
@NamedQuery(name = "Jogo.pesquisarPorJogoID", query = "select u from Jogo u where u.jogoID = :jogoID")
public class Jogo implements Serializable {
	
	private static final long serialVersionUID = -5689130024280386640L;

	public static final String PESQUISAR_POR_JOGOID = "Jogo.pesquisarPorJogoID";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jogoID;
	
	private Calendar data = new GregorianCalendar();
	
	@ManyToOne
	private Inscricao timeA;
	
	@ManyToOne
	private Inscricao timeB;
	
	private Local local;
	private Usuario arbitro;
	private Relatorio relatorio;
	private Jogo prox_jogo;
	

	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Inscricao getTimeA() {
		return timeA;
	}
	public void setTimeA(Inscricao timeA) {
		this.timeA = timeA;
	}
	public Inscricao getTimeB() {
		return timeB;
	}
	public void setTimeB(Inscricao timeB) {
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
	public int getJogoID() {
		return jogoID;
	}
	public void setJogoID(int jogoID) {
		this.jogoID = jogoID;
	}
}
