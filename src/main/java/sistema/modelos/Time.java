package sistema.modelos;

public class Time {
	private int id_time;
	private String nome;
	private Usuario diretor;
	private Inscricao inscricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getDiretor() {
		return diretor;
	}
	public void setDiretor(Usuario diretor) {
		this.diretor = diretor;
	}
	public int getId_time() {
		return id_time;
	}
	public void setId_time(int id_time) {
		this.id_time = id_time;
	}
	public Inscricao getInscricao() {
		return inscricao;
	}
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
}
