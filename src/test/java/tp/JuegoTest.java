package tp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import jugador.Accion;
import jugador.AccionMovimiento;
import jugador.Jugador;
import terreno.ConfigSuelo;
import terreno.Suelo;
import terreno.Suelo1;

public class JuegoTest {

	@Test
	public void MoverDerecha() {
		Jugador pj = new Jugador(2,0,10,10);
		ConfigSuelo configSuelo = new Suelo1(4,4);
		Suelo suelo = new Suelo(configSuelo);
		Juego juego = new Juego(suelo, null, pj);
		var acciones = new ArrayList<Accion>();
		
		var mover = new AccionMovimiento(pj, suelo, null, 1, 0);
		acciones.add(mover);
		juego.realizarAccion(acciones);
		
		assertEquals(pj.getPosicion().getX(), 3);
	}
	
	@Test
	public void MoverIzquierda() {
		Jugador pj = new Jugador(2,0,10,10);
		ConfigSuelo configSuelo = new Suelo1(4,4);
		Suelo suelo = new Suelo(configSuelo);
		Juego juego = new Juego(suelo, null, pj);
		var acciones = new ArrayList<Accion>();
		
		var mover = new AccionMovimiento(pj, suelo, null, -1, 0);
		acciones.add(mover);
		juego.realizarAccion(acciones);
		
		assertEquals(pj.getPosicion().getX(), 1);
	}
	
	@Test
	public void recibirInput() {
		var acciones = new ArrayList<Accion>();
		Jugador pj = new Jugador(2,0,10,10);
		Juego juego = new Juego(null, null, pj);
		juego.convertirInput('W', acciones);
		assertEquals(acciones.size(), 1);
	}
	
	@Test
	public void recibirMultiplesInputs() {
		var acciones = new ArrayList<Accion>();
		Jugador pj = new Jugador(2,0,10,10);
		Juego juego = new Juego(null, null, pj);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		assertEquals(acciones.size(), 5);
	}
	
	@Test
	public void inputCorrecto() {
		var acciones = new ArrayList<Accion>();
		Jugador pj = new Jugador(3, 1,10,10);
		ConfigSuelo configSuelo = new Suelo1(4,4);
		Suelo suelo = new Suelo(configSuelo);
		Juego juego = new Juego(suelo, null, pj);
		juego.convertirInput('W', acciones);
		juego.realizarAccion(acciones);
		assertEquals(pj.getPosicion().getY(), 0);
	}
}