package jugador;

public class Posicion {
	private int posicionX;
	private int posicionY;
	
	public Posicion(int posicionX, int posicionY) {
		if(posicionX < 0 || posicionY < 0) {
			this.posicionX = 0;
			this.posicionY = 0;
			return;
		}
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	//Devuelve la componente X de la posicion
	public int getX() {
		return posicionX;
	}
	
	//Devuelve la componente Y de la posicion
	public int getY() {
		return posicionY;
	}

	//Devuelve la posicion actual.
	public Posicion get() {
		return new Posicion(this.getX(),this.getY());
	}
	
	//Setea la componente X si es positiva.
	public void setX(int posicionX) {
		if(posicionX < 0) {
			return;
		}
		this.posicionX = posicionX;
	}
	
	//Setea la componente Y si es positiva.
	public void setY(int posicionY) {
		if(posicionY < 0) {
			return;
		}
		this.posicionY = posicionY;
	}
	
	//Setea las posiciones X e Y si son positivas.
	public void set(int posicionX, int posicionY) {
		if(posicionX < 0 || posicionY < 0) {
			return;
		}
		else {
			this.setX(posicionX);
			this.setY(posicionY);
		}
	}
	
	//Devuelve true si la posición recibida por parámetro es igual que la actual.
	public boolean esPosicionIgual(Posicion pos2) {
		if(this.posicionX == pos2.posicionX && this.posicionY == pos2.posicionY) {
			return true;
		}
		return false;
	}
	
	
}
