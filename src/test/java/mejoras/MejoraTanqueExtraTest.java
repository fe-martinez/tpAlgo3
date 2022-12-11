package mejoras;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import jugador.Jugador;

public class MejoraTanqueExtraTest {

	@Test
	public void cargaCorrectamente() {
        Jugador pj = new Jugador(5, 0,10,10);
		Usable mejora = new MejoraTanqueExtra();
		pj.getNave().setCapacidadDelTanque(100);
		pj.getNave().setNivelDeCombustible(0);
		mejora.utilizar(pj);
		assertEquals(25 , pj.getNave().getNivelDeCombustible(), 0.01);
	}
	
	@Test
	public void elJugadorNoGastaDinero() {
        Jugador pj = new Jugador(5, 0,10,10);
		Usable mejora = new MejoraTanqueExtra();
		int antes = pj.getDinero();
		mejora.utilizar(pj);
		int despues = pj.getDinero();
		assertEquals(antes, despues);
	}

}
