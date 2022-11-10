package terreno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jugador.Jugador;
import tp.Main;

public class PisoSuperiorTest {

	   @Test
	    public void hayColisionConEntidad() {
		   var config = new ConfigPisoSuperior();
		   PisoSuperior piso = new PisoSuperior(config);
		   Jugador pj = new Jugador((int)(Main.ANCHO * 0.3) , 0, 10, Main.ANCHO);
		   assertTrue(piso.colisionEntidad(pj.getPosicion()) != null);
	    }
	   
	   @Test
	    public void noHayColisionConEntidad() {
		   var config = new ConfigPisoSuperior();
		   PisoSuperior piso = new PisoSuperior(config);
		   Jugador pj = new Jugador((int)(Main.ANCHO * 0.1) , 0, 10, Main.ANCHO);
		   assertTrue(piso.colisionEntidad(pj.getPosicion()) == null);
	    }
	   
	   @Test
	   public void tiendasInicializanCorrectamente() {
		   var config = new ConfigPisoSuperior();
		   PisoSuperior piso = new PisoSuperior(config);
		   assertEquals(piso.devolverTiendas().size(), 5);
	   }

}