package mejoras;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.Jugador;

public class MejoraMaxVidaTest {

	@Test
	public void mejoraCorrectamente() {
		Jugador pj = new Jugador(5, 0, 10, 10);
		int capacidadNueva = 80;
		var mejora = new MejoraMaxVida(capacidadNueva, 100);
		mejora.utilizar(pj);
		assertEquals(pj.getNave().getMaxHP(), capacidadNueva);
	}
	
	@Test
	public void noAceptaNegativos() {
		Jugador pj = new Jugador(5, 0, 10, 10);
		int capacidadNueva = -80;
		var mejora = new MejoraMaxVida(capacidadNueva, 100);
		int capacidadVieja = pj.getNave().getMaxHP();
		mejora.utilizar(pj);
		assertEquals(pj.getNave().getMaxHP(), capacidadVieja);
	}
	
	@Test
	public void noAchicaHP() {
		Jugador pj = new Jugador(5, 0, 10, 10);
		int capacidadNueva = 5;
		var mejora = new MejoraMaxVida(capacidadNueva, 100);
		int capacidadVieja = pj.getNave().getMaxHP();
		mejora.utilizar(pj);
		assertEquals(pj.getNave().getMaxHP(), capacidadVieja);
	}
}
