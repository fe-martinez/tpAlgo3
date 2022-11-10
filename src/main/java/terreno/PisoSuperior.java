package terreno;

import java.util.Map;
import jugador.Posicion;

public class PisoSuperior {
	public ConfigPiso config;

	public PisoSuperior(ConfigPiso config) {
		if(config == null) {
			//throw an exception
			return;
		}
		this.config = config;
	}
	
	//Verifica si hay colision con una entidad.
	public Entidad colisionEntidad(Posicion pos) {
		if(this.config.getTiendas() != null) {
			return this.config.getTiendaPos(pos.getX());
		}
		return null;
	}
	
	//Devuelve las tiendas.
	public Map<Integer, Entidad> devolverTiendas(){
		return this.config.getTiendas();
	}
}
