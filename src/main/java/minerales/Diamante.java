package minerales;

public class Diamante extends Mineral{
	private static final char LETRA = 'D';
	private static int PRECIO = 650;
	
	public Diamante() {
		super(Diamante.PRECIO,Diamante.LETRA);
	}
}
