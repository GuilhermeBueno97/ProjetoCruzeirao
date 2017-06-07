package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import sistema.service.CampeonatoService;

@Entity
@Table(name="inscricoes")
@NamedQuery(name = "Inscricao.pesquisarPorNome", query = "select u from Inscricao u where u.time.nome = :nome")
public class Inscricao implements Serializable{
	
	private static final long serialVersionUID = 3043991500968640285L;
	public static final String PESQUISAR_POR_NOME = "Inscricao.pesquisarPorNome";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_inscricao;
	
	private ArrayList<Usuario> jogadores = new ArrayList<Usuario>();
	
	@ManyToOne
	private Time time;
	
	@ManyToOne
	private Categoria categoria;
	
	private Usuario tecnico;
	private boolean pagamento;
	private boolean validada;
	
	@OneToMany(mappedBy="timeA")
	private ArrayList<Jogo> partidas = new ArrayList<Jogo>();
	
	@Transient
	CampeonatoService campService = new CampeonatoService();
	
	public Campeonato getCampeonato(){
		
		for(Campeonato c : campService.getCampeonatos())
		{
			for(Categoria cat : c.getCategorias())
			{
				if(cat.equals(categoria))
				{
					return c;
				}
			}
		}
		return null;
	}
	
	public Inscricao()
	{
		pagamento = false;
		validada = false;
	}
	
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
	public void addPartidas(Jogo jogo) {
		this.partidas.add(jogo);
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
	public void addJogador(Usuario u){
		jogadores.add(u);
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
