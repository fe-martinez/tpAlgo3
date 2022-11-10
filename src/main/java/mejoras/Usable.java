package mejoras;

import jugador.Jugador;

public abstract class Usable {
	private char letra;
	private TipoUsable tipo;
	private int costo;

	public Usable(char letra, TipoUsable tipo, int costo) {
		this.letra = letra;
		this.tipo = tipo;
		this.costo = costo;
	}

	public void utilizar(Jugador jugador) {
	}
	
	public char getLetra() {
		return this.letra;
	}
	
	public TipoUsable getTipo() {
		return this.tipo;
	}
	
	public int getCosto() {
		return this.costo;
	}
}
