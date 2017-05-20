package sistema.dao;

import java.util.HashMap;
import java.util.Map;

import sistema.modelos.Categoria;

public class CategoriaDAO extends GenericoDAO<Categoria>{
	
	protected Class<Categoria> getClassEentidade(){
		return Categoria.class;
	}
	
	public Categoria pesquisarPorNome(String catName){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome",catName);
		
		return super.pesquisarUm(Categoria.PESQUISAR_POR_NOME, parametros);
	}
}
