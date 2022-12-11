package mejoras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import jugador.Jugador;
import jugador.Posicion;

public class MejoraTeleportTest {

    @Test
    public void seTeletransportaAlPisoDelTerreno() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.setY(10);
    	Usable mejoraTeleport = new MejoraTeleport();
    	mejoraTeleport.utilizar(jugador);
    	assertEquals(jugador.getY(), 8, 0.1);
    }
    
    @Test
    public void seTeletransporta() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.setX(9);
    	jugador.setY(10);
    	Posicion posicionAnterior = new Posicion(jugador.getX(), jugador.getY());
    	Usable mejoraTeleport = new MejoraTeleport();
    	mejoraTeleport.utilizar(jugador);
    	assertFalse(posicionAnterior.esPosicionIgual(jugador.getPosicion()));
    }

}
