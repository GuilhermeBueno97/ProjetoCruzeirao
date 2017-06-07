package sistema.modelos;

public enum Papel {
	ADMIN, DIRETOR, COMUM, ORGANIZADOR, TECNICO, JUIZ, JOGADOR;

	public String toString() {
		switch (this) {
		case ADMIN:
			return "ADMIN";
		case DIRETOR:
			return "DIRETOR";
		case COMUM:
			return "COMUM";
		case ORGANIZADOR:
			return "ORGANIZADOR";
		case TECNICO:
			return "TECNICO";
		case JUIZ:
			return "JUIZ";
		case JOGADOR:
			return "JOGADOR";
		}
		return null;
	}
}
