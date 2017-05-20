package sistema.dao;

import java.util.HashMap;
import java.util.Map;

import sistema.modelos.Campeonato;

public class CampeonatoDAO extends GenericoDAO<Campeonato>{
	
	protected Class<Campeonato> getClassEentidade(){
		return Campeonato.class;
	}
	
	public Campeonato pesquisarPorNome(String campName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",campName);
		
		return super.pesquisarUm(Campeonato.PESQUISAR_POR_NOME, parametros);
	}
}
