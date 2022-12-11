package terreno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import jugador.Jugador;

public class PisoSuperiorTest {

	   @Test
	    public void hayColisionConEntidad() {   
		   Jugador pj = new Jugador((int)(64 * 0.3), 0, 20, 64);
		   PisoSuperior piso = new PisoSuperior(pj);
		   assertTrue(piso.colisionEntidad(pj.getPosicion()) != null);
	    }
	   
	   @Test
	    public void noHayColisionConEntidad() {
		   Jugador pj = new Jugador((int)(64 * 0.1) , 0, 10, 64);
		   PisoSuperior piso = new PisoSuperior(pj);
		   assertTrue(piso.colisionEntidad(pj.getPosicion()) == null);
	    }
	   
	   @Test
	   public void tiendasInicializanCorrectamente() {
		   Jugador pj = new Jugador(0, 0, 0, 0);
		   PisoSuperior piso = new PisoSuperior(pj);
		   assertEquals(piso.getTiendas().size(), 5);
	   }

}