package sistema.dao;

import java.util.HashMap;
import java.util.Map;

import sistema.modelos.Inscricao;

public class InscricaoDAO extends GenericoDAO<Inscricao>{
	
	protected Class<Inscricao> getClassEentidade(){
		return Inscricao.class;
	}
	
	public Inscricao pesquisarPorNome(String inscName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",inscName);
		
		return super.pesquisarUm(Inscricao.PESQUISAR_POR_NOME, parametros);
	}
}
