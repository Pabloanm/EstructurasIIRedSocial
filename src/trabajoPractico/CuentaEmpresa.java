package trabajoPractico;

public class CuentaEmpresa extends Cuenta{
	private String mail;
	private int telefono;
	private String direccion;
	
	public void setMailEmpresa(String m) {
		this.mail = m;
	}
	public String getMailEmpresa () {
		return this.mail;
	}
	public void setTelefonoEmpresa(int telefono) {
		this.telefono = telefono;
	}
	public int getTelefonoEmpresa () {
		return this.telefono;
	}
	public void setDireccionEmpresa(String dir) {
		this.direccion = dir;
	}
	public String getDireccionEmpresa() {
		return this.direccion;
	}
	
	public void mostrarDatosCuentaEmpresa() {
		System.out.println("Datos " + this.getNombreUsuario());
		System.out.println("Mail empresa: " + this.mail);
		System.out.println("Telefono empresa: " + this.telefono);
		System.out.println("Direccion empresa:" + this.direccion);
	}
}
