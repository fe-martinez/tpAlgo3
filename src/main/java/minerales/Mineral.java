package minerales;

import terreno.Bloque;

public abstract class Mineral implements Bloque {
	private int precio;
	private char letra;
	
	public Mineral(int precio, char letra) {
		this.precio = precio;
		this.letra = letra;
	}
	
	//Devuelve el precio.
	public int getPrecio() {
		return this.precio;
	}
	
	//Devuelve la letra que representa al Mineral actual.
	public char getLetra() {
		return this.letra;
	}
}
