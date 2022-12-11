package mejoras;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.AccionItem;
import jugador.Jugador;
import jugador.Posicion;
import terreno.Aire;
import terreno.Suelo;

public class MejoraDinamitaTest {

	@Test
	public void explotaCorrectamente() {
		Suelo config = new Suelo(20, 20);
        Jugador jugador = new Jugador(15, 15, 20, 20);
		var dinamita = new MejoraDinamita(config);
		jugador.getInventario().agregarUsable(dinamita);
		var accion = new AccionItem(jugador, dinamita);
		accion.aplicar();
		
		boolean explotoCorrectamente = true;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				explotoCorrectamente &= config.getBloque(new Posicion(15 + i, 15 + j)) instanceof Aire;
			}
		}
		assertTrue(explotoCorrectamente);
	}
}
