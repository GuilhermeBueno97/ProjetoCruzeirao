package sistema.modelos;

import java.util.Date;

public class Pessoa {
	private String nome;
	private String cpf;
	private String rg;
	private Date data_nasc;
	private String email;
	
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
