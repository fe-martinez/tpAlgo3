package mejoras;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.Jugador;

public class MejoraCapacidadDelTanqueTest {

	@Test
	public void mejoraCorrectamente() {
		Jugador pj = new Jugador(5, 0, 10, 10);
		int capacidadNueva = 80;
		var mejora = new MejoraCapacidadDelTanque(capacidadNueva, 100);
		mejora.utilizar(pj);
		assertTrue(pj.getNave().getCapacidadTanque() == capacidadNueva);
	}
	
	@Test
	public void noAceptaNegativos() {
		Jugador pj = new Jugador(5, 0, 10, 10);
		int capacidadNueva = -80;
		var mejora = new MejoraCapacidadDelTanque(capacidadNueva, 100);
		double capacidadVieja = pj.getNave().getCapacidadTanque();
		mejora.utilizar(pj);
		assertEquals(pj.getNave().getCapacidadTanque(), capacidadVieja, 0.01);
	}
	
	@Test
	public void noAchicaElTanque() {
		Jugador pj = new Jugador(5, 0, 10, 10);
		int capacidadNueva = 5;
		var mejora = new MejoraCapacidadDelTanque(capacidadNueva, 100);
		double capacidadVieja = pj.getNave().getCapacidadTanque();
		mejora.utilizar(pj);
		assertEquals(pj.getNave().getCapacidadTanque(), capacidadVieja, 0.01);
	}

}
