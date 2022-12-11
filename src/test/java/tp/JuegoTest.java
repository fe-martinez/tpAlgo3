package tp;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import jugador.Accion;
import jugador.AccionMovimiento;

public class JuegoTest {

	@Test
	public void MoverDerecha() {
		Juego juego = new Juego(20, 20, null);
		var acciones = new ArrayList<Accion>();
		
		var mover = new AccionMovimiento(juego.getJugador(), 1, 0);
		acciones.add(mover);
		juego.update(acciones, 0);
		
		assertEquals(juego.getJugador().getVelX(), 1, 0.01);
	}
	
	@Test
	public void MoverIzquierda() {
		Juego juego = new Juego(20, 20, null);
		var acciones = new ArrayList<Accion>();
		
		var mover = new AccionMovimiento(juego.getJugador(), -1, 0);
		acciones.add(mover);
		juego.update(acciones, 0);
		
		assertEquals(juego.getJugador().getVelX(), -1, 0.01);
	}
}