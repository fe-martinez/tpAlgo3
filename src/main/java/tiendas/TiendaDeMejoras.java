package tiendas;

import java.util.Map;
import java.util.Scanner;

import jugador.Jugador;
import jugador.Posicion;
import mejoras.MejoraCapacidadDelTanque;
import mejoras.MejoraInstantanea;
import mejoras.MejoraMaxInventario;
import mejoras.MejoraMaxVida;
import mejoras.Usable;
import terreno.Entidad;
import terreno.TipoEntidad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TiendaDeMejoras extends Entidad{
	private static final char LETRA = '+';
	private static final TipoEntidad TIPO = TipoEntidad.TIENDA;
	private static final List<Integer> TIERS_PRECIO = Arrays.asList(750, 2000, 5000, 20000, 100000, 150000);
	private static final List<Integer> TIERS_MAX_CAPACIDAD = Arrays.asList(15, 25, 40, 60, 70, 120);
	Scanner input;
	Posicion posicion;
	Map<String, MejoraInstantanea> mejoras;
	Map<String, Usable> usables;
	
	public TiendaDeMejoras(Posicion posicion) {
		super(posicion, TIPO, LETRA);
		this.posicion = posicion;
		this.mejoras = new HashMap<>();
		this.inicializarMejoras();
	}

	//Inicializa las mejoras que se pueden comprar junto con sus precios.
	private void inicializarMejoras() {
		this.mejoras.put("I1", new MejoraMaxInventario(TIERS_MAX_CAPACIDAD.get(0), TIERS_PRECIO.get(0)));
		this.mejoras.put("I2", new MejoraMaxInventario(TIERS_MAX_CAPACIDAD.get(1), TIERS_PRECIO.get(1)));
		this.mejoras.put("I3", new MejoraMaxInventario(TIERS_MAX_CAPACIDAD.get(2), TIERS_PRECIO.get(2)));
		this.mejoras.put("I4", new MejoraMaxInventario(TIERS_MAX_CAPACIDAD.get(3), TIERS_PRECIO.get(3)));
		this.mejoras.put("I5", new MejoraMaxInventario(TIERS_MAX_CAPACIDAD.get(4), TIERS_PRECIO.get(4)));
		this.mejoras.put("I6", new MejoraMaxInventario(TIERS_MAX_CAPACIDAD.get(5), TIERS_PRECIO.get(5)));
				
		this.mejoras.put("V1", new MejoraMaxVida(17, TIERS_PRECIO.get(0)));
		this.mejoras.put("V2", new MejoraMaxVida(30, TIERS_PRECIO.get(1)));
		this.mejoras.put("V3", new MejoraMaxVida(50, TIERS_PRECIO.get(2)));
		this.mejoras.put("V4", new MejoraMaxVida(80, TIERS_PRECIO.get(3)));
		this.mejoras.put("V5", new MejoraMaxVida(120, TIERS_PRECIO.get(4)));
		this.mejoras.put("V6", new MejoraMaxVida(180, TIERS_PRECIO.get(5)));
		
		this.mejoras.put("T1", new MejoraCapacidadDelTanque(TIERS_MAX_CAPACIDAD.get(0), TIERS_PRECIO.get(0)));
		this.mejoras.put("T2", new MejoraCapacidadDelTanque(TIERS_MAX_CAPACIDAD.get(1), TIERS_PRECIO.get(1)));
		this.mejoras.put("T3", new MejoraCapacidadDelTanque(TIERS_MAX_CAPACIDAD.get(2), TIERS_PRECIO.get(2)));
		this.mejoras.put("T4", new MejoraCapacidadDelTanque(TIERS_MAX_CAPACIDAD.get(3), TIERS_PRECIO.get(3)));
		this.mejoras.put("T5", new MejoraCapacidadDelTanque(TIERS_MAX_CAPACIDAD.get(4), TIERS_PRECIO.get(4)));
		this.mejoras.put("T6", new MejoraCapacidadDelTanque(TIERS_MAX_CAPACIDAD.get(5), TIERS_PRECIO.get(5)));
		
	}
	
	//Elimina la mejora según el código especificado.
	private void eliminarMejora(String codigo) {
		this.mejoras.remove(codigo);
	}
	
	//Recibe la opcion elegida y genera el código de búsqueda.
	private String codigoMejora(char opcion, int tier) {
		String busqueda = "";
		busqueda += opcion;
		busqueda += tier;
		return busqueda;
	}
	
	//Imprime por pantalla las opciones que hay para comprar.
	private void promptMejoras() {
		System.out.println("----------------------------------------");
		System.out.println("Mejora a comprar:");
		System.out.println("I para mejoras del inventario\nV para mejoras de vida\nT para mejoras de tanque");
		System.out.print("Opcion: ");
	}
	
	//Imprime por pantalla las mejoras que hay para comprar según la opción elegida.
	private void promptOpciones(char opcion) {
		if(opcion == 'I') {
			System.out.println("Seleccione el tier de mejora: ");
			System.out.println("(1)+15 por $750\n(2)+25 por $2000\n(3)+40 por $5000\n(4)+60 por $20000\n(5)+70 por $100000\n(6)+120 por $150000");
			System.out.print("Opcion: ");
		} else if(opcion == 'V') {
			System.out.println("Seleccione el tier de mejora: ");
			System.out.println("(1)+17 por $750\n(2)+30por $2000\n(3)+50 por $5000\n(4)+80 por $20000\n(5)+120 por $100000\n(6)+180 por $150000");
			System.out.print("Opcion: ");
		} else if(opcion == 'T') {
			System.out.println("Seleccione el tier de mejora: ");
			System.out.println("(1)+15 por $750\n(2)+25 por $2000\n(3)+40 por $5000\n(4)+60 por $20000\n(5)+70 por $100000\n(6)+120 por $150000");
			System.out.print("Opcion: ");
		} else {
			System.out.println("Todavia no tenemos ese item a la venta :P");
		}
	}
	
	
	//Permite vender la Mejora dada al Jugador dado.
	public void vender(Jugador jugador, MejoraInstantanea mejora) {
		mejora.utilizar(jugador);
		jugador.hacerCompra(mejora.getValor());	
	}

	//Permite al Jugador dado interactuar con la Tienda actual.
	@Override
	public void interactuar(Jugador jugador) {
		this.input = new Scanner(System.in);
		promptMejoras();
		char opcion = input.next().charAt(0);
	
		promptOpciones(opcion);
		int tier = input.nextInt();
		String codigo = codigoMejora(opcion, tier);
		
		MejoraInstantanea mejora = this.mejoras.get(codigo);
		if(mejora == null) {
			System.out.println("No tenemos esa mejora o ya la vendimos :(");
			return;
		}
		
		vender(jugador, mejora);
		eliminarMejora(codigo);
	}
}
