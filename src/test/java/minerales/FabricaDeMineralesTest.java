package minerales;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabricaDeMineralesTest {

	@Test
	public void devuelveMineralCorrecto() {
		assertEquals(FabricaDeMinerales.crear("Cobre").getBloqueID(), 'C');
	}
	
	@Test
	public void noDevuelveInexistentes() {
		assertEquals(FabricaDeMinerales.crear("Boca"), null);
	}

}
