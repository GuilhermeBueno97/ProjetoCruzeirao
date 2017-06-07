package sistema.dao;

import java.util.HashMap;
import java.util.Map;

import sistema.modelos.Categoria;
import sistema.modelos.Convite;

public class ConviteDAO extends GenericoDAO<Convite> {
	protected Class<Categoria> getClassEentidade(){
		return Categoria.class;
	}
	
	public Convite pesquisarPorID(int conviteID){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",conviteID);
		
		return super.pesquisarUm(Convite.PESQUISAR_POR_ID, parametros);
	}
}
