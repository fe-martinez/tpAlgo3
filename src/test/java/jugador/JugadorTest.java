package jugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mejoras.MejoraTeleport;
import mejoras.Usable;
import minerales.Cobre;
import minerales.FabricaDeMinerales;
import minerales.Mineral;

public class JugadorTest {

	@Test
    public void losMineralesSeAñadenCorrectamente() {
        Jugador jugador = new Jugador(5, 0, 10, 10);
        jugador.observarBloque(FabricaDeMinerales.crear("Cobre"));
        assertEquals(jugador.getInventario().getCantidadDeMinerales(), 1);
    }


    @Test
    public void losMineralesSeVendenCorrectamente() {
        Jugador jugador = new Jugador(5, 0,10,10);
        for(int i = 0; i < 5; i++) {
        	jugador.observarBloque(new Cobre());
        }
        jugador.getInventario().venderMinerales();
        assertEquals(jugador.getInventario().getCantidadDeMinerales(), 0);
    }

    @Test
    public void elLmiteDeInventarioNoSePuedeSobrepasar() {
        Jugador jugador = new Jugador(5, 0,10,10);
        Mineral cobre = FabricaDeMinerales.crear("Cobre");
        for(int i = 0; i < 7; i++) {
            jugador.observarBloque(cobre);
        }
        int antes = jugador.getInventario().getCantidadDeMinerales();
        jugador.observarBloque(cobre);
        int despues = jugador.getInventario().getCantidadDeMinerales();
        assertEquals(antes,despues);
    }
   
    @Test
    public void noSePuedeCrearJugadorFueraDelSuelo() {
        
    }
    
    @Test
    public void sePuedeHacerCompra() {
    	Jugador jugador = new Jugador(5, 0, 10, 10);
    	jugador.setDinero(120);
    	assertTrue(jugador.hacerCompra(110));
    }
    
    @Test
    public void noSePuedeHacerCompra() {
        Jugador jugador = new Jugador(5, 0,10,10);
    	jugador.setDinero(100);
    	assertFalse(jugador.hacerCompra(110));
    }
    
    @Test
    public void elJugadorNoSePuedePosicionarFueraDeLosLimites(){
    	Jugador jugador = new Jugador(5,0,10,10);
    	Posicion posicionInicial = jugador.getPosicion();
    	jugador.setX(11);
    	jugador.setY(11);
    	Posicion posicionFinal = jugador.getPosicion();
    	assertEquals(posicionInicial,posicionFinal);
    }
   
    
    @Test
    public void jugadorSinCombustible() {
    	Nave nave = new Nave();    	
    	nave.gastarCombustible(nave.getNivelDeCombustible());
    	assertTrue(nave.seQuedoSinCombustible());
    }
    
    @Test
    public void jugadorTieneCombustible() {
    	Nave nave = new Nave();
    	assertFalse(nave.seQuedoSinCombustible());
    }
        
    @Test
    public void noSePuedeActualizarLimiteDeInventarioAUnoMasPequenio() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	
    }
    
    @Test
    public void noSePuedeActualizarMaxHPAUnoMasPequenio() {
    	
    }
    
    @Test
    public void noSePuedeActualizarCapacidadDelTanquePorUnaMenorALaActual() {
    	Nave nave = new Nave();
    	double antes = nave.getCapacidadTanque();
    	nave.agregarCapacidadAlTanque(10);
    	double despues = nave.getCapacidadTanque();
    	assertEquals(antes, despues, 0.01);
    }
    
    @Test
    public void sePuedeActualizarCapacidadDelTanquePorUnaMayorALaActual() {
    	Nave nave = new Nave();
    	double antes = nave.getCapacidadTanque();
    	nave.agregarCapacidadAlTanque(20);
    	double despues = nave.getCapacidadTanque();
    	assertNotEquals(antes,despues);
    }
    
    @Test
    public void jugadorNoTieneUsable() {
    	Inventario inv = new Inventario();
    	Usable usable = new MejoraTeleport();
    	assertFalse(inv.tieneUsable(usable));
    }
    
    @Test
    public void losUsablesSeAgreganCorrectamente() {
    	Inventario inv = new Inventario();
    	Usable usable = new MejoraTeleport();
    	inv.agregarUsable(usable);
    	assertTrue(inv.tieneUsable(usable));
    }
    
    @Test
    public void losUsablesSeEliminanCorrectamente() {
    	Inventario inv = new Inventario();
    	Usable usable = new MejoraTeleport();
    	inv.agregarUsable(usable);
    	int antes = inv.getUsables().size();
    	inv.eliminarUsable(usable);
    	int despues = inv.getUsables().size();
    	assertNotEquals(antes,despues);
    }
    
    @Test
    public void noSePuedeGastarCombustibleNegativo() {
    	
    }
    
    @Test
    public void seGastaCombustibleSuficienteParaQueElJugadorSeQuedeSinCombustible() {
    	Nave nave = new Nave();
    	nave.gastarCombustible(100);
    	assertTrue(nave.seQuedoSinCombustible());
    }
      
    @Test
    public void elCombustibleSeGastaCorrectamente() {
       	Nave nave = new Nave();
    	double antes = nave.getNivelDeCombustible();
    	nave.gastarCombustible(5);
    	double despues = nave.getNivelDeCombustible();
    	assertNotEquals(antes,despues);
    }
    
    @Test
    public void seRecibeDanioSuficienteParaQueElJugadorSeEstrelle() {
    	Nave nave = new Nave();
    	nave.recibirDanio(100);
    	assertTrue(nave.seEstrello());
    }

    /*
    @Test
    public void 
    
    @Test
    public void
    */
}
