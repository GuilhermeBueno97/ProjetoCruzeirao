package sistema.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name="users")
@NamedQuery(name = "Usuario.pesquisarPorUsername", query = "select u from Usuario u where u.username = :username")
public class Usuario implements Serializable{
	
	public static final long serialVersionUID = 6360850095345609468L;
	
	public static final String PESQUISAR_POR_USERNAME = "Usuario.pesquisarPorUsername";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_usuario;

	private Papel papel;
	private String nome;
	private String cpf;
	private String rg;
	private Calendar data_nasc = new GregorianCalendar();
	private String username;
	private String senha;
	private String email;
	private ArrayList<Convite> convites = new ArrayList<Convite>();
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Calendar getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Calendar data_nasc) {
		this.data_nasc = data_nasc;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_usuario ^ (id_usuario >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id_usuario != other.id_usuario)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/*@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", papeis=" + papeis + ", nome=" + nome + ", cpf=" + cpf
				+ ", username=" + username + ", senha=" + senha + ", email=" + email + "]";
	}*/
	
	@Override
	public String toString() {
		return nome;
	}
	public String getUserAtual(){
		return (((SecurityContext) SecurityContextHolder.getContext()).getAuthentication().getName());
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	
	public ArrayList<Convite> getConvites() {
		return convites;
	}

	public void setConvites(ArrayList<Convite> convites) {
		this.convites = convites;
	}
	
	public void addConvite(Convite c){
		this.convites.add(c);
	}
	public void removeConvite(Convite c){
		this.convites.remove(c);
	}
}
