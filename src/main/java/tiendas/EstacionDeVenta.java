package tiendas;

import java.util.Scanner;
import jugador.Jugador;
import jugador.Posicion;
import terreno.Entidad;
import terreno.TipoEntidad;

public class EstacionDeVenta extends Entidad {
	public Posicion posicion;
	private static final char RESPUESTA_AFIRMATIVA = 'S';
	private static final char LETRA = '/';
	private static final TipoEntidad TIPO = TipoEntidad.TIENDA;
	private Scanner sc;
	

	public EstacionDeVenta(Posicion pos) {
		super(pos, TIPO, LETRA);
		this.posicion = pos;
		this.sc = null;
	}
	
	//Imprime por pantalla el mensaje de la Tienda.
	public void prompt_mensaje_venta() {
		System.out.println("-----------------------------------");
		System.out.println("Desea vender?");
	}
	
	//Permite que la Tienda interactúe con el Jugador dado.
	public void interactuar(Jugador jugador) {
		prompt_mensaje_venta();
		this.sc = new Scanner(System.in);
		char respuesta = sc.next().charAt(0);
		if(respuesta == RESPUESTA_AFIRMATIVA) {
			vender(jugador);
		}
	}
	
	//Devuelve la letra de la Tienda actual.
	public char getLetra() {
		return EstacionDeVenta.LETRA;
	}
		
	//Devuelve la posición de la Tienda.
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	//Devuelve el tipo de entidad.
	public TipoEntidad getTipoEntidad() {
		return TipoEntidad.TIENDA;
	}

	//Permite vender los minerales al Jugador dado.
	public void vender(Jugador jugador) {
		jugador.venderMinerales();
	}
	
}
