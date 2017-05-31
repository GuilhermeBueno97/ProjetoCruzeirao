package sistema.dao;

import java.util.HashMap;
import java.util.Map;

import sistema.modelos.Local;

public class LocalDAO extends GenericoDAO<Local>{
	
	protected Class<Local> getClassEentidade(){
		return Local.class;
	}
	
	public Local pesquisarPorNome(String locName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",locName);
		
		return super.pesquisarUm(Local.PESQUISAR_POR_NOME, parametros);
	}
}
