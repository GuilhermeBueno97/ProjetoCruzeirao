package sistema.modelos;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inscricoes")
public class Inscricao {
	
	@Id
	private int id_inscricao;
	
	private ArrayList<Usuario> jogadores = new ArrayList<Usuario>();
	private Time time;
	private Categoria categoria;
	private Usuario tecnico;
	private boolean pagamento;
	private boolean validada;
	private ArrayList<Jogo> partidas = new ArrayList<Jogo>();
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public ArrayList<Jogo> getPartidas() {
		return partidas;
	}
	public void setPartidas(ArrayList<Jogo> partidas) {
		this.partidas = partidas;
	}
	public boolean isValidada() {
		return validada;
	}
	public void setValidada(boolean validada) {
		this.validada = validada;
	}
	public int getId_inscricao() {
		return id_inscricao;
	}
	public void setId_inscricao(int id) {
		this.id_inscricao = id;
	}
	public ArrayList<Usuario> getJogadores() {
		return jogadores;
	}
	public void setJogadores(ArrayList<Usuario> jogadores) {
		this.jogadores = jogadores;
	}
	public Usuario getTecnico() {
		return tecnico;
	}
	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}
	public boolean getPagamento() {
		return pagamento;
	}
	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
}
