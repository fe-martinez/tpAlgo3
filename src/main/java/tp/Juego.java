package tp;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import jugador.Accion;
import jugador.AccionItem;
import jugador.AccionMovimiento;
import jugador.Jugador;
import mejoras.*;
import terreno.PisoSuperior;
import terreno.Suelo;
import terreno.Vista;

public class Juego {		
	private Suelo suelo;
	private PisoSuperior tiendas;
	private Jugador jugador;
	private Vista vista;
	private Scanner input;
	private Map<Character, Accion> controles;
	
	public Juego(Suelo suelo, PisoSuperior tiendas, Jugador jugador) {
		this.suelo = suelo;
		this.jugador = jugador;
		this.tiendas = tiendas;
		this.input = null;
		this.vista = new Vista(tiendas, suelo, jugador, jugador.getInventario(), Main.ANCHO, Main.ALTURA);
		
		//Usa Character de momento pero con JavaFX pasaria a ser KeyCode.
		final Map<Character, Accion> controles = Map.of(
				'W', new AccionMovimiento(jugador, suelo, tiendas, 0, -1),
				'S', new AccionMovimiento(jugador, suelo, tiendas, 0, 1),
				'D', new AccionMovimiento(jugador, suelo, tiendas, 1, 0),
				'A', new AccionMovimiento(jugador, suelo, tiendas, -1, 0),
				'F', new AccionItem(jugador, new MejoraTanqueExtra()),
				'Q', new AccionItem(jugador, new MejoraTeleport()),
				'R', new AccionItem(jugador, new MejoraHullRepairNanobots()),
				'X', new AccionItem(jugador, new MejoraDinamita(suelo))
				);
		this.controles = controles;
	}
	
	//Indica el estado del juego actual.
	//Si el jugador no puede continuar, devuelve PERDIDO.
	//Si el jugador llegó al final del terreno, devuelve GANADO.
	//En todo otro caso, devuelve JUGANDO.
	private EstadoDelJuego estadoJuego(){
		if(jugador.noPuedeContinuar()){
			return EstadoDelJuego.PERDIDO;
		}
		if(jugador.getY() == suelo.getAlto()) {
			return EstadoDelJuego.GANADO;
		}
		
		return EstadoDelJuego.JUGANDO;
	}
	
	//Recibe un movimiento y lo convierte en una Accion, que será añadida a la lista de acciones si es válida.
	public void convertirInput(char movimiento, ArrayList<Accion> acciones) {
		Accion accion = controles.get(movimiento);
		if(accion != null) {
			acciones.add(accion);
		}
	}
	
	//Realiza las acciones que encuentra en la lista de acciones y las remueve de la misma.
	//De momento, para ser utilizada por consola funciona de esta manera, pero la idea es que sea un loop que ejecute todas las acciones,
	//una por cada una de las teclas que estan siendo presionadas de momento.
	public void realizarAccion(ArrayList<Accion> acciones) {
		if(acciones.size() > 0) {
			if(acciones.get(0) != null) {
				acciones.get(0).aplicar();
			}
			acciones.remove(0);
		}
	}
	
	//Genera el loop del juego: ingresa un movimiento e imprime el Terreno mientras el estado del juego sea JUGANDO.
	public void gameLoop() {
		this.input = new Scanner(System.in);
		var acciones = new ArrayList<Accion>();
		vista.imprimir(jugador);
		while(this.estadoJuego() == EstadoDelJuego.JUGANDO) {
			char movimiento = input.next().charAt(0);
			convertirInput(movimiento, acciones);
			realizarAccion(acciones);
			vista.imprimir(jugador);
		}
	}
		
}
