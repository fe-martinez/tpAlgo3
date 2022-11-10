package terreno;

import jugador.Posicion;

public class Suelo {
	ConfigSuelo config;
	
	public Suelo(ConfigSuelo config) {
		if(config == null) {
			//throw an exception
		}
		
		this.config = config;
		
	}
	
	//Devuelve el bloque de la posición especificada.
	public Bloque getBloque(Posicion pos) {
		return config.getBloque(pos);
	}
	
	//Destruye el bloque de la posición especificada.
	public void destruirBloque(Posicion pos) {
		config.destruirBloque(pos);
	}
	
	//Devuelve true si el casillero de la posición especificada está vacío, false en caso contrario.
	public boolean casilleroVacio(Posicion posicion) {
		return config.casilleroVacio(posicion);
	}
	
	//Devuelve el alto del suelo.
	public int getAlto() {
		return config.getAlto();
	}
	
	
}
