package terreno;

import java.util.Map;

import jugador.Posicion;
import tiendas.EstacionDeReparacion;
import tiendas.EstacionDeServicio;
import tiendas.EstacionDeVenta;
import tiendas.TiendaDeConsumibles;
import tiendas.TiendaDeMejoras;
import tp.Main;
import java.util.HashMap;

public class ConfigPisoSuperior implements ConfigPiso {
	Map<Integer, Entidad> tiendas;

	public ConfigPisoSuperior(){
		this.crearConfiguracion();
	}

	//Crear una configuracion especificada.
	public void crearConfiguracion() {
		var ypf = new EstacionDeServicio(new Posicion((int)(Main.ANCHO * 0.3), 0));
		var mecanico = new EstacionDeReparacion(new Posicion((int)(Main.ANCHO * 0.6), 0));
		var mejoras = new TiendaDeMejoras(new Posicion((int)(Main.ANCHO * 0.9), 0));
		var consumibles = new TiendaDeConsumibles(new Posicion((int)(Main.ANCHO * 0.7), 0));
		var estacionDeVentas = new EstacionDeVenta(new Posicion((int)(Main.ANCHO * 0.4), 0));

		this.tiendas = new HashMap<Integer, Entidad>();
	
		tiendas.put(ypf.getPosicion().getX(), ypf);
		tiendas.put(mecanico.getPosicion().getX(), mecanico);
		tiendas.put(mejoras.getPosicion().getX(), mejoras);
		tiendas.put(consumibles.getPosicion().getX(), consumibles);
		tiendas.put(estacionDeVentas.getPosicion().getX(),estacionDeVentas);
	}
	
	//Devuelve el diccionario de las tiendas
	public Map<Integer, Entidad> getTiendas(){
		return this.tiendas;
	}
	
	@Override
	public Entidad getTiendaPos(int posX) {
		return tiendas.get(posX);
	}
}
