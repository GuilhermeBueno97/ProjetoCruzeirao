package sistema.modelos;

import java.util.ArrayList;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQuery(name = "Usuario.pesquisarPorUsername", query = "select u from Usuario u where u.username = :username")
public class Usuario extends Pessoa implements Serializable{
	
	public static final long serialVersionUID = 6360850095345609468L;
	
	public static final String PESQUISAR_POR_USERNAME = "Usuario.pesquisarPorUsername";
	
	@Id
	@GeneratedValue
	private int id_usuario;
	
	@Transient
	private ArrayList<Papel> papeis = new ArrayList<Papel>();
	
	private String username;
	private String senha;
	private String email;
	private String cpf;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getId() {
		return id_usuario;
	}
	public String getIdString() {
		return Integer.toString(id_usuario);
	}
	public void setId(int id) {
		this.id_usuario = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(ArrayList<Papel> papeis) {
		this.papeis = papeis;
	}
	
	@Override
	public String toString(){
		return "Usuario [id= " + id_usuario + ", nome= " + getNome() + ", CPF= " + cpf + ", Senha= " + senha;
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
}
