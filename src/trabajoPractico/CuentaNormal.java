package trabajoPractico;
import java.util.*;
public class CuentaNormal extends Cuenta {
	private List<Cuenta> seguidos;
	
	public CuentaNormal() {
		this.seguidos = new ArrayList<Cuenta>();
	}
	public void mostrarDatosCuentaNormal () {
		System.out.println("Seguidos: " + this.seguidos.size());
	}
	public void addSeguidos (Cuenta c) {
		this.seguidos.add(c);
	}
}


