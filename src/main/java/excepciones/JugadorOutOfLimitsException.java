package excepciones;

public class JugadorOutOfLimitsException extends Exception {
	public JugadorOutOfLimitsException() {
		super("El jugador no puede posicionarse por afuera del terreno");
	}
}
