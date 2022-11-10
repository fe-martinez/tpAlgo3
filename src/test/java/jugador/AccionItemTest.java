package jugador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mejoras.MejoraDinamita;
import mejoras.MejoraTeleport;
import mejoras.Usable;
import terreno.ConfigSuelo;
import terreno.Suelo;
import terreno.Suelo1;
import tp.Main;

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
		ConfigSuelo configSuelo = new Suelo1(Main.ALTURA,Main.ANCHO);
		Suelo suelo = new Suelo(configSuelo);
		var mejora = new MejoraDinamita(suelo);
		jugador.getInventario().agregarUsable(mejora);
		AccionItem AccionItem = new AccionItem(jugador,mejora);
		assertEquals(true, AccionItem.aplicar());
	}
	
	@Test
	public void noSeAplicaLaMejoraConTerreno() {
		Jugador jugador = new Jugador(10, 10, 10, 10);
		ConfigSuelo configSuelo = new Suelo1(Main.ALTURA,Main.ANCHO);
		Suelo suelo = new Suelo(configSuelo);
		var mejora = new MejoraDinamita(suelo);
		AccionItem AccionItem = new AccionItem(jugador, mejora);
		assertEquals(false,AccionItem.aplicar());
	}
	
	@Test
	public void seGastaElItemDeTerreno() {
		Jugador jugador = new Jugador(10, 10, 10, 10);
		ConfigSuelo configSuelo = new Suelo1(Main.ALTURA,Main.ANCHO);
		Suelo suelo = new Suelo(configSuelo);
		var mejora = new MejoraDinamita(suelo);
		jugador.getInventario().agregarUsable(mejora);
		AccionItem accion = new AccionItem(jugador, mejora);
		int cantidadVieja = jugador.getInventario().getUsables().size();
		
		accion.aplicar();
	}
		

}

