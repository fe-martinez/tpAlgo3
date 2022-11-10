package mejoras;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jugador.Inventario;
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
	
	//Podríamos agregar tests en caso de que decidamos que se guarde lo que sobre (si no se carga todo el tanque extra)
	//quizás podríamos ver de que la mejora se elimine cuando cantidad == 0 o algo de eso :P

}
