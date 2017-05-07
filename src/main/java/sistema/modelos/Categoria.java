package sistema.modelos;

import java.util.ArrayList;

public class Categoria {
	private int id_categoria;
	private String nome;
	private int idade_min;
	private char sexo;
	private boolean insc_jogadores;
	private boolean insc_times;
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
	public boolean isInsc_jogadores() {
		return insc_jogadores;
	}
	public void setInsc_jogadores(boolean insc_jogadores) {
		this.insc_jogadores = insc_jogadores;
	}
	public boolean isInsc_times() {
		return insc_times;
	}
	public void setInsc_times(boolean insc_times) {
		this.insc_times = insc_times;
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
}
