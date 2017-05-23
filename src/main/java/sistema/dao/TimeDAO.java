package sistema.dao;

import java.util.HashMap;
import java.util.Map;
import sistema.modelos.Time;

public class TimeDAO extends GenericoDAO<Time>{
	
	protected Class<Time> getClassEentidade(){
		return Time.class;
	}
	
	public Time pesquisarPorNome(String timeName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",timeName);
		
		return super.pesquisarUm(Time.PESQUISAR_POR_NOME, parametros);
	}
}