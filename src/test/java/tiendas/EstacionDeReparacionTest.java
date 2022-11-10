package tiendas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jugador.Inventario;
import jugador.Jugador;
import jugador.Posicion;

public class EstacionDeReparacionTest {
	private static final int PRECIO_REPARACION = 10;
	@Test
	public void venderFull() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.getNave().setHP(1);
		jugador.setDinero(1000);
		
		var mecanico = new EstacionDeReparacion(new Posicion(5, 0));
		mecanico.vender(jugador, 1000);
		
		assertEquals(jugador.getNave().getHP(), jugador.getNave().getMaxHP());
	}
	
	@Test
	public void vender100Gasto() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.getNave().setHP(0);
		jugador.getNave().setMaxHP(100);
		jugador.setDinero(1000);
		
		var mecanico = new EstacionDeReparacion(new Posicion(5, 0));
		mecanico.vender(jugador, 100);
		
		assertEquals(jugador.getNave().getHP(), 100/PRECIO_REPARACION);
	}
	
	@Test
	public void venderSinDinero() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.getNave().setHP(0);
		jugador.setDinero(0);
		
		var mecanico = new EstacionDeReparacion(new Posicion(5, 0));
		mecanico.vender(jugador, 100);
		
		assertEquals(jugador.getNave().getHP(), 0);
	}
	
	@Test
	public void gastoCorrecto() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.getNave().setHP(1);
		jugador.getNave().setMaxHP(100);
		jugador.setDinero(55);
		
		var mecanico = new EstacionDeReparacion(new Posicion(5, 0));
		mecanico.vender(jugador, 50);
		assertEquals(5, jugador.getDinero());
	}

}