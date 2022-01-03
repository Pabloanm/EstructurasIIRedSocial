package trabajoPractico;
import java.util.UUID;
import java.util.*;
public  class Cuenta {
	private String nombreUsuario;
	private String mailUsuario;
	private Fecha nacimientoUsuario;
	private String idUsuario;
	private List<Publicaciones> pizarra;
	private Fecha fechaApertura; 
	private Boolean estado;
	private List<Cuenta> seguidores;
	private List<Publicaciones> feed;
	
	public Cuenta() {
		this.idUsuario = UUID.randomUUID().toString().substring(0,6);
		Fecha f = new Fecha();
		this.nacimientoUsuario = f;
		Fecha f2 = new Fecha ();
		this.fechaApertura = f2;
		this.estado = true;
		this.pizarra = new ArrayList<Publicaciones>();
		this.seguidores = new ArrayList<Cuenta>();
		this.feed = new ArrayList<Publicaciones>();
	}
	public void setNombreUsuario (String nombre){
		this.nombreUsuario = nombre;
	}
	public String getNombreUsuario () {
		return this.nombreUsuario;
	}
	public void setMail (String mail) {
		this.mailUsuario = mail;
	}
	public String getMail (String mail) {
		return this.mailUsuario;
	}
	public void setNacimiento (int dia, int mes, int año) {
		this.nacimientoUsuario.dia = dia;
		this.nacimientoUsuario.mes = mes;
		this.nacimientoUsuario.año = año;
	}
	public void setFechaApertura (int dia, int mes, int año) {
		this.fechaApertura.dia = dia;
		this.fechaApertura.mes = mes;
		this.fechaApertura.año = año;
	}
	
	public void setEstado (Boolean est) {
		this.estado =  est;
	}
	public Boolean getEstado () {
		return this.estado;
	}
	public int getSizePizzara() {
		return this.pizarra.size();
	}
	public Publicaciones getPublicacionPizzara(int i) {
		return this.pizarra.get(i);
	}
	public String getFechaNacimiento () {
		return (this.nacimientoUsuario.dia + "/" + this.nacimientoUsuario.mes + "/" + this.nacimientoUsuario.año);
	}

	public void mostrarDatosCuenta () {
		System.out.println("Nombre usuario: " + getNombreUsuario());
		System.out.println("Mail usuario: " + this.mailUsuario);
		System.out.println("Fecha nacimiento: " + this.getFechaNacimiento()) ;
		System.out.println("Id de usuario:" + this.idUsuario);
		if (this.estado == true) {
			System.out.println("La cuenta esta abierta.");
		}else {
			System.out.println("La cuenta esta suspendida.");
		}
			System.out.println("Seguidores: " + this.seguidores.size());
	}
	public void verFeed () {
		if (this.feed.size() == 0) {
			System.out.println("El feed de " + this.nombreUsuario + " esta vacio.");
		}else {
			System.out.println("El feed de " + this.nombreUsuario + " tiene las siguientes publicaciones:\n");
			for (Publicaciones p : feed) {
				p.mostrarPublicacion();
				System.out.println("\n");
			}
		}
	}
	
	public void verPizarra() {
		int i = 0;
		if (this.pizarra.size()>0) {
			System.out.println("La pizarra de " + this.nombreUsuario + " tiene las siguientes publicaciones: \n");
			for (Publicaciones p:this.pizarra) {
				p.mostrarPublicacion(i);
				i ++;
				System.out.println("\n");
			}
		}else {
			System.out.println("La pizarra de " + this.nombreUsuario + " no tiene publicaciones.");
		}
	}
	
	public void publicar (Publicaciones p) {
		if (this.estado == true) {
			agregarFeed (p);
			for (Cuenta c: seguidores) {
				c.agregarPublicacionSeguidores(c, p);
			}
			if (p.getSizeEtiquetados() > 0) {
				for (Cuenta c: p.getEtiquetados()) {
					if (this.buscarSeguidores(this, c) == false){
						this.agregarPublicacionSeguidores(c, p);
					}
				}
			}
		}else {
			System.out.println("Cuenta suspendida, no puede realizar publicaciones.");
		}
	}
	
	public void agregarFeed (Publicaciones p) {
		Boolean agregar = false;
		Publicaciones p2 = new Publicaciones();
		if (this.feed.size() > 0) {
			for (int i = 0; i < this.feed.size(); i++) {
				p2 = this.feed.get(i);
				if (p2.getFecha().fechaMayor(p.getFecha(), p2.getFecha())) {
					this.feed.add(i, p);
					agregar = true;
					break;
				}
			}
			if (agregar == false) {
				this.feed.add(p);
			}
		}else {
			this.feed.add(p);
		}
	}
	
	public void agregarPublicacionSeguidores(Cuenta c, Publicaciones p) {
		Publicaciones p2 = new Publicaciones();
		if (c.getSizePizzara() > 0) {
			for (int i = 0; i < c.getSizePizzara(); i++) {
				p2 = c.pizarra.get(i);
				if (p2.getFecha().fechaMayor(p.getFecha(), p2.getFecha())) {
					c.pizarra.add(i, p);
					return;
				}
			}
			c.pizarra.add(p);
		}else {
			c.pizarra.add(p);
		}
	}
	
	
	
	public void seguir (Cuenta c1, Cuenta c2) {    //C1 SIGUE A C2
		if (c1 instanceof CuentaEmpresa) {
			System.out.println("Error.Las cuentas empresa no pueden seguir otras cuentas.");
		}
		if (c1 instanceof CuentaFamoso) {
			if (c2 instanceof CuentaNormal) {
				System.out.println("Error.Las cuentas de famosos no pueden seguir cuentas normales.");
			}else {
				((CuentaFamoso) c1).addSeguidos(c2);;
				c2.seguidores.add(c1);
			}
		}
		if (c1 instanceof CuentaNormal) {
			((CuentaNormal) c1).addSeguidos(c2);
			c2.seguidores.add(c1);
		}
	}
	public Boolean buscarSeguidores (Cuenta c1, Cuenta c2) {       //BUSCA A C2 EN LOS SEGUIDORES DE C1
		for (Cuenta c: c1.seguidores) {
			if (c == c2) {
				return true;
			}
		}
		return false;
	}
	
	public void republicar (Publicaciones p, RedSocial r) {
		if (p.getRepublicable() == true) {
			List<String> e = new ArrayList<String>();
			Publicaciones p2 = new Publicaciones();
			p2.crearPublicacion(this, r, 26, 6, 2021, "(republicado) " + p.getContenido(), true, e, false);
			this.publicar(p2);
		}else {
			System.out.println("Error. La publicacion no puede republicarse.");
		}
	}
	
	public void likear (Publicaciones p) {
		if (p.getLikeable() == true) {
			p.like(this);
		}else {
			System.out.println("Error. La publicacion no permite likes.");
		}
		
	}
	
	public int alcanceCuenta (Cuenta c) { 
		int contador = 0;
		List<Cuenta> lCuentas = new ArrayList<Cuenta>();
		lCuentas.addAll(this.seguidores);
		lCuentas.add(c);
		contador = this.seguidores.size();
		for (Cuenta aux:this.seguidores) {
			for (Cuenta aux2: aux.seguidores) {
				if (buscarCuenta (lCuentas, aux2) == false) {
					contador ++;
					lCuentas.add(aux2);
				}
			}
		}
		return contador;
	}
	
	public Boolean buscarCuenta (List<Cuenta> lCuentas, Cuenta c) {
		for (Cuenta aux:lCuentas) {
			if (aux == c) {
				return true;
			}
		}
		return false;
	}
}




