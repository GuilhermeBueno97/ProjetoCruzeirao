package sistema.modelos;

import java.util.ArrayList;
import java.util.Date;

public class Campeonato {
	private int id_campeonato;
	private String nome;
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	private Date data_inicio;
	private Date data_fim;
	private Date data_insc_inicio;
	private Date data_insc_fim;
	private double taxa_insc;
	private int jogadores_min;
	private int jogadores_max;
	
	public int getId() {
		return id_campeonato;
	}
	public void setId(int id) {
		this.id_campeonato = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	public Date getData_insc_inicio() {
		return data_insc_inicio;
	}
	public void setData_insc_inicio(Date data_insc_inicio) {
		this.data_insc_inicio = data_insc_inicio;
	}
	public Date getData_insc_fim() {
		return data_insc_fim;
	}
	public void setData_insc_fim(Date data_insc_fim) {
		this.data_insc_fim = data_insc_fim;
	}
	public double getTaxa_insc() {
		return taxa_insc;
	}
	public void setTaxa_insc(double taxa_insc) {
		this.taxa_insc = taxa_insc;
	}
	public int getJogadores_min() {
		return jogadores_min;
	}
	public void setJogadores_min(int jogadores_min) {
		this.jogadores_min = jogadores_min;
	}
	public int getJogadores_max() {
		return jogadores_max;
	}
	public void setJogadores_max(int jogadores_max) {
		this.jogadores_max = jogadores_max;
	}
}
