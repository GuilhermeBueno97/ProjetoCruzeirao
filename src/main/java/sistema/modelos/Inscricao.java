package sistema.modelos;

import java.util.ArrayList;

public class Inscricao {
	private int id_inscricao;
	private ArrayList<Usuario> jogadores = new ArrayList<Usuario>();
	private Campeonato campeonato;
	private Usuario tecnico;
	private Usuario preparador_fisico;
	private Usuario massagista;
	private boolean pagamento;
	
	public int getId() {
		return id_inscricao;
	}
	public void setId(int id) {
		this.id_inscricao = id;
	}
	public ArrayList<Usuario> getJogadores() {
		return jogadores;
	}
	public void setJogadores(ArrayList<Usuario> jogadores) {
		this.jogadores = jogadores;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public Usuario getTecnico() {
		return tecnico;
	}
	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}
	public Usuario getPreparador_fisico() {
		return preparador_fisico;
	}
	public void setPreparador_fisico(Usuario preparador_fisico) {
		this.preparador_fisico = preparador_fisico;
	}
	public Usuario getMassagista() {
		return massagista;
	}
	public void setMassagista(Usuario massagista) {
		this.massagista = massagista;
	}
	public boolean isPagamento() {
		return pagamento;
	}
	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
}
