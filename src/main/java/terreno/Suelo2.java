package terreno;

import java.util.Random;

import jugador.Posicion;
import minerales.FabricaDeMinerales;

public class Suelo2 implements ConfigSuelo {
	private Bloque[][] bloques;
	private int alto;
	private int ancho;
	private Random rand;
	
	private Bloque ponerBloque() {
		this.rand = new Random();
		int valor = rand.nextInt(100);
		
		if(valor > 0 && valor < 60) {
			return new Tierra();
		} else if(valor >= 60 && valor < 80) {
			return FabricaDeMinerales.crear("Cobre");
		} else if(valor >= 80 && valor < 92) {
			return FabricaDeMinerales.crear("Plata");
		} else if(valor >= 92 && valor < 98) {
			return FabricaDeMinerales.crear("Oro");
		} else {
			return FabricaDeMinerales.crear("Diamante");
		}
	}
	
	
	public Suelo2(int alto, int ancho) {
		if(alto < 0 || ancho < 0) {
			//throw an exception
		}
		
		this.alto = alto;
		this.ancho = ancho;
		
		var bloques = new Bloque[alto][ancho];
		
		for(int k = 0; k < this.ancho; k++) {
			bloques[0][k] = new Aire();
		}
		
		for(int i = 1; i < alto; i++) {
			for(int j = 0; j < ancho; j++) {
				bloques[i][j] = ponerBloque();
			}
		}
		
		this.bloques = bloques;
	}
	
	public Bloque getBloque(Posicion pos) {
		return(bloques[pos.getY()][pos.getX()]);
	}
	
	public void destruirBloque(Posicion pos) {
		bloques[pos.getY()][pos.getX()] = new Aire();
	}
	
	public boolean casilleroVacio(Posicion posicion) {
		if(posicion.getY() == this.alto - 1) {
			return false;
		}
		
		return(bloques[posicion.getY()][posicion.getX()] instanceof Aire);
	}


	@Override
	public int getAlto() {
		return this.alto;
	}
}