package mejoras;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.Jugador;

public class MejoraHullRepairNanobotsTest {

	@Test
	public void sumaVida() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		jugador.getNave().setHP(1);
		var mejora = new MejoraHullRepairNanobots();
		mejora.utilizar(jugador);
		assertEquals(jugador.getNave().getHP(), jugador.getNave().getMaxHP());
	}
	
	@Test
	public void sumaCorrectamente() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		jugador.getNave().setHP(1);
		jugador.getNave().setMaxHP(100);
		var mejora = new MejoraHullRepairNanobots();
		mejora.utilizar(jugador);
		assertEquals(jugador.getNave().getHP(), 31);
	}

}
