package terreno;

import java.util.Map;

public interface ConfigPiso {
	public void crearConfiguracion();
	public Map<Integer, Entidad> getTiendas();
	public Entidad getTiendaPos(int posX);
}
