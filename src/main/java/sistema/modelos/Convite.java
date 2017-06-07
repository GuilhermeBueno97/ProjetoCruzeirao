package sistema.modelos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="convites")
@NamedQuery(name = "Convite.pesquisarPorID", query = "select u from Convite u where u.conviteID = :conviteID")
public class Convite implements Serializable{
	
	private static final long serialVersionUID = -4763657574829695601L;
	
	public static final String PESQUISAR_POR_ID = "Categoria.pesquisarPorID";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int conviteID;
	
	private Inscricao inscricao;
	
	private Usuario user;	
	
	private Calendar data = new GregorianCalendar();
	
	public Inscricao getInscricao() {
		return inscricao;
	}
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
}
