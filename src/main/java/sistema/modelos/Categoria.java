package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
@NamedQuery(name = "Categoria.pesquisarPorNome", query = "select u from Categoria u where u.nome = :nome")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = -2189917791581761038L;

	public static final String PESQUISAR_POR_NOME = "Categoria.pesquisarPorNome";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_categoria;
	
	private String nome;
	private int idade_min;
	private char sexo;
	private boolean insc_jogadores;
	private ArrayList<Time> times = new ArrayList<Time>();
	private ArrayList<Jogo> partidas = new ArrayList<Jogo>();
	
	public int getId() {
		return id_categoria;
	}
	public void setId(int id) {
		this.id_categoria = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade_min() {
		return idade_min;
	}
	public void setIdade_min(int idade_min) {
		this.idade_min = idade_min;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public boolean getInsc_jogadores() {
		return insc_jogadores;
	}
	public void setInsc_jogadores(boolean insc_jogadores) {
		this.insc_jogadores = insc_jogadores;
	}
	public ArrayList<Time> getTimes() {
		return times;
	}
	public void setTimes(ArrayList<Time> times) {
		this.times = times;
	}
	public ArrayList<Jogo> getPartidas() {
		return partidas;
	}
	public void setPartidas(ArrayList<Jogo> partidas) {
		this.partidas = partidas;
	}
	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nome=" + nome + ", idade_min=" + idade_min + ", sexo="
				+ sexo + ", insc_jogadores=" + insc_jogadores + ", times=" + times
				+ ", partidas=" + partidas + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_categoria;
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
		Categoria other = (Categoria) obj;
		if (id_categoria != other.id_categoria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
