package jugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import mejoras.MejoraDinamita;
import mejoras.MejoraTeleport;
import mejoras.Usable;
import terreno.Suelo;

public class AccionItemTest {

	@Test
	public void seAplicaLaMejora() {
		Jugador jugador = new Jugador(10, 10, 10, 10);
		Usable mejora = new MejoraTeleport();
		jugador.getInventario().agregarUsable(mejora);
		AccionItem accionItem = new AccionItem(jugador, mejora);
		assertEquals(true, accionItem.aplicar());
	}
	
	@Test
	public void noSeAplicaLaMejora() {
		Jugador jugador = new Jugador(10, 10, 10, 10);
		Usable mejora = new MejoraTeleport();
		AccionItem accionItem = new AccionItem(jugador, mejora);
		assertEquals(false, accionItem.aplicar());
	}
	
	@Test
	public void seGastaElItem() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		Usable mejora = new MejoraTeleport();
		jugador.getInventario().agregarUsable(mejora);
		AccionItem accion = new AccionItem(jugador, mejora);
		
		int cantidadVieja = jugador.getInventario().getUsables().size();
		accion.aplicar();
		int cantidadNueva = jugador.getInventario().getUsables().size();
		
		assertEquals(cantidadNueva, cantidadVieja - 1);
	}
	
	@Test
	public void seAplicaLaMejoraConTerreno() {
		Jugador jugador = new Jugador(10, 10, 10, 10);
		Suelo configSuelo = new Suelo(64, 64);
		var mejora = new MejoraDinamita(configSuelo);
		jugador.getInventario().agregarUsable(mejora);
		AccionItem AccionItem = new AccionItem(jugador,mejora);
		assertEquals(true, AccionItem.aplicar());
	}
	
	@Test
	public void noSeAplicaLaMejoraConTerreno() {
		Jugador jugador = new Jugador(10, 10, 10, 10);
		Suelo configSuelo = new Suelo(64, 64);
		var mejora = new MejoraDinamita(configSuelo);
		AccionItem AccionItem = new AccionItem(jugador, mejora);
		assertEquals(false,AccionItem.aplicar());
	}
	
	@Test
	public void seGastaElItemDeTerreno() {
		Jugador jugador = new Jugador(10, 10, 10, 10);
		Suelo configSuelo = new Suelo(64, 64);
		var mejora = new MejoraDinamita(configSuelo);
		jugador.getInventario().agregarUsable(mejora);
		AccionItem accion = new AccionItem(jugador, mejora);
		int cantidadVieja = jugador.getInventario().getUsables().size();
		accion.aplicar();
		int cantidadNueva = jugador.getInventario().getUsables().size();
		
		assertNotEquals(cantidadVieja, cantidadNueva);
	}
		

}

