package terreno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jugador.Jugador;
import tp.Main;

public class PisoSuperiorTest {

	   @Test
	    public void hayColisionConEntidad() {
		   PisoSuperior piso = new PisoSuperior();
		   Jugador pj = new Jugador((int)(Main.ANCHO * 0.3) , 0, 10, Main.ANCHO);
		   assertTrue(piso.colisionEntidad(pj.getPosicion()) != null);
	    }
	   
	   @Test
	    public void noHayColisionConEntidad() {
		   PisoSuperior piso = new PisoSuperior();
		   Jugador pj = new Jugador((int)(Main.ANCHO * 0.1) , 0, 10, Main.ANCHO);
		   assertTrue(piso.colisionEntidad(pj.getPosicion()) == null);
	    }
	   
	   @Test
	   public void tiendasInicializanCorrectamente() {
		   PisoSuperior piso = new PisoSuperior();
		   assertEquals(piso.getTiendas().size(), 5);
	   }

}