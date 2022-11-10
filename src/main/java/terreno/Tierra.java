package terreno;

public class Tierra implements Bloque {
	private static final char LETRA = 'T';
	
	public Tierra() {
	}

	//Devuelve la letra que representa la clase.
	public char getLetra() {
		return Tierra.LETRA;
	}

}
