package trabajoPractico;
import java.util.*;
public class CuentaFamoso extends Cuenta{
	private List<Cuenta> seguidos;
	
	public CuentaFamoso() {
		this.seguidos = new ArrayList<Cuenta>();
	}
	public void mostrarDatosFamoso() {
		System.out.println("Seguidos: " + this.seguidos.size());
	}
	public void addSeguidos (Cuenta c) {
		this.seguidos.add(c);
	}
}

