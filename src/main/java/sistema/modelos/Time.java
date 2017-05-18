package sistema.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="times")
@NamedQuery(name = "Time.pesquisarPorNome", query = "select u from Time u where u.nome = :nome")
public class Time implements Serializable{
	
	private static final long serialVersionUID = 706847541461043949L;

	public static final String PESQUISAR_POR_NOME = "Time.pesquisarPorNome";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_time;
	
	private String nome;
	
	private Usuario diretor;
	
	@Transient
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
	@Override
	public String toString() {
		return "Time [id_time=" + id_time + ", nome=" + nome + ", diretor=" + diretor + ", inscricao=" + inscricao
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_time;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (id_time != other.id_time)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
