package jugador;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import terreno.Suelo;

public class AccionMovimientoTest {
	@Test
	public void MovimientoIzquierda() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		int vieja = jugador.getPosicion().getX();
		Suelo configSuelo = new Suelo(10,10);
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, -1, 0);
		mov.aplicar();
		int nueva = jugador.getPosicion().getX();
		assertEquals(nueva, vieja - 1);
	}
	
	@Test
	public void MovimientoDerecha() {
		Jugador jugador = new Jugador(5,0,10,10);
		int vieja = jugador.getPosicion().getX();
		Suelo configSuelo = new Suelo(10,10);
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 1, 0);
		mov.aplicar();
		int nueva = jugador.getPosicion().getX();
		assertEquals(nueva, vieja + 1);
	}
	
	@Test
	public void MovimientoAbajo() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		int vieja = jugador.getPosicion().getY();
		Suelo configSuelo = new Suelo(10,10);
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 0, 1);
		mov.aplicar();
		int nueva = jugador.getPosicion().getY();
		assertEquals(nueva, vieja + 1);
	}
	
	@Test
	public void MovimientoArriba() {
		Jugador jugador = new Jugador(5,1,10,10);
		int vieja = jugador.getPosicion().getY();
		Suelo configSuelo = new Suelo(10,10);
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 0, -1);
		mov.aplicar();
		int nueva = jugador.getPosicion().getY();
		assertEquals(nueva, vieja - 1);
	}
	
	@Test
	public void MovimientoArribaConBloque() {
		Jugador jugador = new Jugador(5,2,10,10);
		int vieja = 2;
		Suelo configSuelo = new Suelo(10,10);
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 0, -1);
		mov.aplicar();
		assertEquals(vieja, jugador.getPosicion().getY());
	}
	
	@Test
	public void Caer() {
		Jugador jugador = new Jugador(5,0,10,10);
		Suelo configSuelo = new Suelo(10,10);
		configSuelo.destruirBloque(new Posicion(5, 1));
		configSuelo.destruirBloque(new Posicion(5, 2));
		configSuelo.destruirBloque(new Posicion(5, 3));
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 0, 1);
		mov.aplicar();
		assertTrue(jugador.getPosicion().esPosicionIgual(new Posicion(5, 3)));
		
	}
	
	@Test
	public void noSaleDeLosLimitesX() {
		Jugador jugador = new Jugador(9, 0, 10, 10);
		Suelo configSuelo = new Suelo(10, 10);
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 1, 0);
		mov.aplicar();
		assertEquals(jugador.getX(), 9);
	}
	
	public void noSaleDeLosLimitesY() {
		Jugador jugador = new Jugador(0, 9, 10, 10);
		Suelo configSuelo = new Suelo(10, 10);
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 0, 1);
		mov.aplicar();
		assertEquals(jugador.getY(), 9);
	}
	
	@Test
	public void sufreFallDamage() {
		Jugador jugador = new Jugador(5, 0, 20, 20);
		Suelo configSuelo = new Suelo(20, 20);
		int hpViejo = jugador.getNave().getHP();
		for(int i = 1; i < 10; i++) {
			configSuelo.destruirBloque(new Posicion(5, i));
		}
		AccionMovimiento mov = new AccionMovimiento(jugador, configSuelo, null, 0, 1);
		mov.aplicar();
		boolean posicionCorrecta = jugador.getY() == 9;
		boolean dmg = jugador.getNave().getHP() < hpViejo;
		
		assertTrue(posicionCorrecta && dmg);
	}
	
	
	
	@Test
	public void Taladrar() {
		
	}
	
}