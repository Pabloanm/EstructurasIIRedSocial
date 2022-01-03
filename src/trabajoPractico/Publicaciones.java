package trabajoPractico;
import java.util.Scanner;
import java.util.*;
public class Publicaciones {
	private Fecha fechaPublicacion;
	private String autor;
	private String contenido;
	private List<Cuenta> etiquetas;
	private Boolean likeable;
	private int likes;
	private Boolean republicar;
	private List<Cuenta> cuentasQueLikearon;
	
	public Publicaciones() {
		Fecha f = new Fecha();
		this.fechaPublicacion = f;
		this.etiquetas = new ArrayList<Cuenta>();
		this.cuentasQueLikearon = new ArrayList<Cuenta>();
	}
	public List<Cuenta> getEtiquetados(){
		return this.etiquetas;
	}
	public int getSizeEtiquetados () {
		return this.etiquetas.size();
	}
	public Boolean getRepublicable () {
		return this.republicar;
	}
	public String getContenido () {
		return this.contenido;
	}
	public Fecha getFecha () {
		return this.fechaPublicacion;
	}
	public Boolean getLikeable () {
		return this.likeable;
	}
	
	public void crearPublicacion(Cuenta c, RedSocial r) {
		System.out.println("Inicia proceso de crear publicacion.");
		this.autor = c.getNombreUsuario();
		this.fechaPublicacion.insertarFecha();
		while (this.fechaPublicacion.validarFecha(fechaPublicacion) == false) {
			//System.out.println("Fecha invalida. Reingrese la fecha del dia de hoy.");
			this.fechaPublicacion.insertarFecha();
		}
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese contenido a publicar: ");
		this.contenido = teclado.nextLine();
		if (c instanceof CuentaNormal) {
			while (this.contenido.length() > 150) {
				System.out.println("Error, slo se permiten 150 caracteres. Por favor reintente.");
				System.out.println("Ingrese contenido a publicar: ");
				this.contenido = teclado.nextLine();
			}
		}else {
			while (this.contenido.length() > 300) {
				System.out.println("Error. Solo se permiten 300 caracteres.");
				System.out.println("Ingrese contenido a publicar.");
				this.contenido = teclado.nextLine();
			}
		}
		System.out.println("¿Desea permitir que otros usuarios likeen la publicacion? 1 = si / 0 = no.");	
		int res = teclado.nextInt();
		while (res < 0 || res > 1) {
			System.out.println("Error, el numero introducido no pertenece a ninguna accion a realizar. Por favor reintente.");
			res = teclado.nextInt();
		}
		if (res == 1) {
			this.likeable = true;
		}else {
			this.likeable = false;
		}
		System.out.println("¿Desea etiquetar otros usuarios? 1 = si / 0 = no.");
		res = teclado.nextInt();
		teclado.nextLine();
		while (res < 0 || res > 1) {
			System.out.println("Error, el numero introducido no pertenece a ninguna accion a realizar. Por favor reintente.");
			res = teclado.nextInt();
		}
		if (res == 1) {
			while (res == 1) {
				System.out.println("Seleccione un usuario de la lista.");
				r.mostrarCuentas();
				int i = teclado.nextInt();
				List <Cuenta> limite = new ArrayList<Cuenta>();
				limite = r.getListaCuentas();
				while (i < 0 || i >= limite.size()) {
					System.out.println("Error, el numero que ingreso es invalido. Por favor reintente");
					i = teclado.nextInt();
				}
				List<Cuenta> lista = new ArrayList<Cuenta>();
				lista = r.getListaCuentas();
				Cuenta aux = lista.get(i);	
				this.etiquetas.add(aux);
				System.out.println("¿Desea etiquetar otros usuarios? 1 = si / 0 = no");
				res = teclado.nextInt();
				teclado.nextLine();
				while (res < 0 || res > 1) {
					System.out.println("Error, el numero introducido no pertenece a ninguna accion a realizar. Por favor reintente.");
					res = teclado.nextInt();
				}
			}
		}
		System.out.println("¿Desea permitir que otros usuarios republiquen esta publicacion? 1 = si / 0 = no");
		res = teclado.nextInt();
		while (res < 0 || res > 1) {
			System.out.println("Error, el numero introducido no pertenece a ninguna accion a realizar.Por favor reintente.");
			res = teclado.nextInt();
		}
		if (res == 1) {
			this.republicar = true;
		}else {
			this.republicar = false;
		}
	}
	
	public void crearPublicacion (Cuenta c, RedSocial r,int dia, int mes, int año, String mensaje,Boolean likeable,  List<String> etiquetados, Boolean republicable) {
		this.autor = c.getNombreUsuario();
		this.fechaPublicacion.dia = dia;
		this.fechaPublicacion.mes = mes;
		this.fechaPublicacion.año = año;
		if (c instanceof CuentaNormal) {
			if (mensaje.length() > 150) {
				System.out.println("Error, el mensaje supera los 150 caracteres permitidos.");
				System.setOut(null);
			}else {
				this.contenido = mensaje;
			}
		}else {
			if (mensaje.length() > 300) {
				System.out.println("Error, el mensaje supera los 300 caracteres permitidos.");
				System.setOut(null);
			}else {
				this.contenido = mensaje;
			}
		}
		this.likeable = likeable;
		this.republicar = republicable;
		if (etiquetados.size() > 0) {
			for (String s:etiquetados) {
				Cuenta c2 = r.buscarCuenta(s);
				this.etiquetas.add(c2);
			}
		}
	}
	public void mostrarPublicacion() {                             
		System.out.println("Autor:" + this.autor);
		System.out.println("Contenido: " + this.contenido);
		System.out.println("Likes: " + this.likes);
		System.out.println("Cuentas etiquetadas:");
		if (this.etiquetas.size() > 0) {
			for (Cuenta c: this.etiquetas) {
				System.out.println(c.getNombreUsuario());
			}
		}else {
			System.out.println("Ninguna.");
		}
	}	
	public void mostrarPublicacion(int i) {
		System.out.println("Autor:" + this.autor);
		System.out.println("Contenido: " + this.contenido);
		System.out.println("Likes: " + this.likes);
		System.out.println("Cuentas etiquetadas:");
		if (this.etiquetas.size() > 0) {
			for (Cuenta c: this.etiquetas) {
				System.out.print(c.getNombreUsuario() + ". ");
			}
		}else {
			System.out.println("Ninguna");
		}
		System.out.println("(PRESIONE " + i + " PARA REALIZAR ACCIONES SOBRE ESTA PUBLICACION)");
	}	
	
	public void like (Cuenta c) {
		if (c.buscarCuenta(cuentasQueLikearon, c) == false) {
			this.likes = this.likes + 1;
			this.cuentasQueLikearon.add(c);
		}
	}
}