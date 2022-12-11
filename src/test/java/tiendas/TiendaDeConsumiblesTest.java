package tiendas;

import static org.junit.Assert.*;
import org.junit.Test;
import jugador.Jugador;
import jugador.Posicion;
import mejoras.MejoraHullRepairNanobots;
import mejoras.TipoUsable;

public class TiendaDeConsumiblesTest {

	@Test
	public void compraExitosa() {
		var tienda = new TiendaDeConsumibles(new Posicion(5, 0));
		Jugador jugador = new Jugador(5, 0, 10, 10);
		jugador.setDinero(10000);
		tienda.vender(jugador, TipoUsable.REPAIR);
		
		boolean cantidadAdecuada = jugador.getInventario().getUsables().size() == 1;
		boolean itemCorrecto = jugador.getInventario().getUsables().get(0) instanceof MejoraHullRepairNanobots;
		
		assertTrue(cantidadAdecuada && itemCorrecto);
	}
	
	@Test
	public void admiteComprasMultiples() {
		var tienda = new TiendaDeConsumibles(new Posicion(5, 0));
		Jugador jugador = new Jugador(5, 0, 10, 10);
		jugador.setDinero(100000);
		tienda.vender(jugador, TipoUsable.REPAIR);
		tienda.vender(jugador, TipoUsable.REPAIR);
		tienda.vender(jugador, TipoUsable.REPAIR);
		tienda.vender(jugador, TipoUsable.REPAIR);
		tienda.vender(jugador, TipoUsable.REPAIR);
		tienda.vender(jugador, TipoUsable.REPAIR);
		
		assertEquals(jugador.getInventario().getUsables().size(), 6);
	}
	
	@Test
	public void descuentaDineroCorrectamente() {
		var tienda = new TiendaDeConsumibles(new Posicion(5, 0));
		Jugador jugador = new Jugador(5, 0, 10, 10);
		jugador.setDinero(100000);
		tienda.vender(jugador, TipoUsable.REPAIR);
		tienda.vender(jugador, TipoUsable.REPAIR);
		
		assertEquals(jugador.getDinero(), 100000 - (2 * MejoraHullRepairNanobots.VALOR));
	}
}
