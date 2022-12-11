package mejoras;

import static org.junit.Assert.*;
import org.junit.Test;
import jugador.Jugador;

public class MejoraMaxInventarioTest {

	@Test
	public void mejoraCorrectamente() {
        Jugador pj = new Jugador(5, 0,10,10);
		int capacidadNueva = 80;
		var mejora = new MejoraMaxInventario(capacidadNueva, 100);
		mejora.utilizar(pj);
		assertEquals(pj.getInventario().getMaxInventario(), capacidadNueva);
	}
	
	@Test
	public void noAceptaNegativos() {
        Jugador pj = new Jugador(5, 0,10,10);
		int capacidadNueva = -80;
		var mejora = new MejoraMaxInventario(capacidadNueva, 100);
		int capacidadVieja = pj.getInventario().getMaxInventario();
		mejora.utilizar(pj);
		assertEquals(pj.getInventario().getMaxInventario(), capacidadVieja);
	}
	
	@Test
	public void noAchicaElInventario() {
        Jugador pj = new Jugador(5, 0,10,10);
		int capacidadNueva = 5;
		var mejora = new MejoraMaxInventario(capacidadNueva, 100);
		int capacidadVieja = pj.getInventario().getMaxInventario();
		mejora.utilizar(pj);
		assertEquals(pj.getInventario().getMaxInventario(), capacidadVieja);
	}

}
