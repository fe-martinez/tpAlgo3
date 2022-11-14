package mejoras;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.AccionItem;
import jugador.Inventario;
import jugador.Jugador;
import jugador.Posicion;
import terreno.Aire;
import terreno.Suelo;

public class MejoraDinamitaTest {

	@Test
	public void explotaCorrectamente() {
		Suelo config = new Suelo(10, 10);
        Jugador jugador = new Jugador(5, 5,10,10);
		var dinamita = new MejoraDinamita(config);
		jugador.getInventario().agregarUsable(dinamita);
		var accion = new AccionItem(jugador, dinamita);
		accion.aplicar();
		
		boolean explotoCorrectamente = true;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				explotoCorrectamente &= config.getBloque(new Posicion(5 + i, 5 + j)) instanceof Aire;
			}
		}
		assertTrue(explotoCorrectamente);
	}
	
	@Test
	public void explotaBordeSuperior() {
		Suelo config = new Suelo(10, 10);
        Jugador jugador = new Jugador(5, 0,10,10);
		var dinamita = new MejoraDinamita(config);
		jugador.getInventario().agregarUsable(dinamita);
		var accion = new AccionItem(jugador, dinamita);
		accion.aplicar();
		
		boolean explotoCorrectamente = true;
		for(int i = -1; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				explotoCorrectamente &= config.getBloque(new Posicion(5 + i, j)) instanceof Aire;
			}
		}
		assertTrue(explotoCorrectamente);
	}


}
