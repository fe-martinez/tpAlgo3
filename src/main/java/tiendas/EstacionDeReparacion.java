package tiendas;

import java.util.Scanner;

import jugador.Jugador;
import jugador.Posicion;
import terreno.Entidad;
import terreno.TipoEntidad;

public class EstacionDeReparacion extends Entidad implements EstacionDeMantenimiento {
	public Posicion posicion;
	private static final int PRECIO_REPARACION = 10;
	private static final char LETRA = '!';
	private static final TipoEntidad TIPO = TipoEntidad.TIENDA;
	private Scanner sc;
	
	
	public EstacionDeReparacion(Posicion posicion) {
		super(posicion, TIPO, LETRA);
	}

	//Imprime por pantalla las opciones de reparación.
	public void prompt_reparacion(int vidaActual) {
		System.out.println("-----------------------------------");
		System.out.println("Su vida actual es " + vidaActual);
		System.out.println("Valor de la reparacion: ");
		System.out.println("50, 100, 200, 500 o 1000(Reparacion completa)");
		System.out.print("Opcion: ");
	}
	
	//Repara la nave del Jugador elegido según la opción de gasto elegido.
	public void vender(Jugador jugador, double gasto) {
		double hpPedidos = gasto/PRECIO_REPARACION;
		double hpFaltante = jugador.getNave().getMaxHP() - jugador.getNave().getHP();
		double hpReparados = hpPedidos < hpFaltante ? hpPedidos : hpFaltante;
		double gastoEfectivo = (hpReparados * PRECIO_REPARACION) < gasto ? (hpReparados * PRECIO_REPARACION) : gasto;
		
		if(jugador.hacerCompra(gastoEfectivo)) {
			jugador.getNave().repararDmg((int)hpReparados);
		}
	}

	@Override
	//Realiza la interacción entre el Jugador y la Tienda.
	public void interactuar(Jugador jugador) {
		prompt_reparacion(jugador.getNave().getHP());
		this.sc = new Scanner(System.in);
		int cantidadPlata = sc.nextInt();
		vender(jugador, cantidadPlata);
	}
}
