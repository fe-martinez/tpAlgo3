package jugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import tp.Juego;

public class AccionMovimientoTest {
	@Test
	public void MovimientoIzquierda() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		var vieja = jugador.getVelX();
		AccionMovimiento mov = new AccionMovimiento(jugador, -1, 0);
		mov.aplicar();
		var nueva = jugador.getVelX();
		assertEquals(nueva, vieja - 1, 0.1);
	}
	
	@Test
	public void MovimientoDerecha() {
		Jugador jugador = new Jugador(5,0,10,10);
		var vieja = jugador.getVelX();
		AccionMovimiento mov = new AccionMovimiento(jugador, 1, 0);
		mov.aplicar();
		var nueva = jugador.getVelX();
		assertEquals(nueva, vieja + 1, 0.1);
	}
	
	@Test
	public void MovimientoAbajo() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		var vieja = jugador.getVelY();
		AccionMovimiento mov = new AccionMovimiento(jugador, 0, 1);
		mov.aplicar();
		var nueva = jugador.getVelY();
		assertEquals(nueva, vieja + 1, 0.1);
	}
	
	@Test
	public void MovimientoArriba() {
		Jugador jugador = new Jugador(5,1,10,10);
		var vieja = jugador.getVelY();
		AccionMovimiento mov = new AccionMovimiento(jugador, 0, -1);
		mov.aplicar();
		var nueva = jugador.getVelY();
		assertEquals(nueva, vieja - 1, 0.1);
	}
	
	@Test
	public void MovimientoArribaConBloque() {
		Jugador jugador = new Jugador(5,2,10,10);
		int vieja = 2;
		AccionMovimiento mov = new AccionMovimiento(jugador, 0, -1);
		mov.aplicar();
		assertEquals(vieja, jugador.getPosicion().getY(), 0.1);
	}
	
	@Test
	public void Caer() {
		Juego juego = new Juego(20, 20, null);
		ArrayList<Accion> acciones = new ArrayList<Accion>();
		
		juego.getSuelo().destruirBloque(new Posicion(5, 9));
		juego.getSuelo().destruirBloque(new Posicion(5, 10));
		juego.getSuelo().destruirBloque(new Posicion(5, 11));
		AccionMovimiento mov = new AccionMovimiento(juego.getJugador(), 0, 0);
		acciones.add(mov);
		juego.update(acciones, 1000000000);
		assertEquals(juego.getJugador().getPosicion().getY(), 12, 1);
	}
	
	@Test
	public void noSaleDeLosLimitesX() {
		Jugador jugador = new Jugador(9, 0, 10, 10);
		AccionMovimiento mov = new AccionMovimiento(jugador, 1, 0);
		mov.aplicar();
		assertEquals(jugador.getX(), 9, 0.1);
	}
	
	public void noSaleDeLosLimitesY() {
		Jugador jugador = new Jugador(0, 9, 10, 10);
		AccionMovimiento mov = new AccionMovimiento(jugador, 0, 1);
		mov.aplicar();
		assertEquals(jugador.getY(), 9, 0.1);
	}
	
	@Test
	public void sufreFallDamage() {
		Juego juego = new Juego(50, 50, null);
		ArrayList<Accion> acciones = new ArrayList<Accion>();
		int hpViejo = juego.getJugador().getNave().getHP();
		juego.getJugador().setVelY(1);
		for(int i = 8; i < 19; i++) {
			juego.getSuelo().destruirBloque(new Posicion(5, i));
		}

		juego.update(acciones, 1000000000);
		
		var dmg = juego.getJugador().getNave().getHP() < hpViejo;
		
		assertTrue(dmg);
	}
	
}