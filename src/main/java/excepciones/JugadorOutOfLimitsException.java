package excepciones;

//Habría que ver qué pingo hace esta excepción ahre
public class JugadorOutOfLimitsException extends Exception {
	public JugadorOutOfLimitsException() {
		super("El jugador no puede posicionarse por afuera del terreno");
	}
}
