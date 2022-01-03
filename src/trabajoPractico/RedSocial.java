package trabajoPractico;
import java.util.Scanner;
import java.util.*;
public class RedSocial {
	private List<Cuenta> cuentas;
	
	public RedSocial() {
		this.cuentas = new ArrayList<Cuenta>();
	}
	public void mostrarCuentas () {
		int i = 0;
		for (Cuenta c: this.cuentas) {
			System.out.println(c.getNombreUsuario() + "  (Presione " + i + " para seleccionar esta cuenta)" );
			i ++;
		}
	}
	public void agregarCuenta(Cuenta c) {
		this.cuentas.add(c);
	}
	public Cuenta buscarCuenta(String nombre) {
		for (Cuenta c: cuentas) {
			if (c.getNombreUsuario() == nombre) {
				return c;
			}
		}
		return null;
	}
	public List<Cuenta> getListaCuentas (){
		return this.cuentas;
	}
	
	public static void main(String[] args) {
		RedSocial red = new RedSocial();
		Cuenta u1 = new CuentaNormal();
		u1.setNombreUsuario("User1");
		u1.setMail("user1@gmail.com");
		u1.setEstado(true);
		u1.setFechaApertura(17, 6, 2021);
		u1.setNacimiento(12, 4, 1993);
		red.agregarCuenta(u1);
		Cuenta u2 = new CuentaNormal();
		u2.setNombreUsuario("User2");
		u2.setMail("User2@gmail.com");
		u2.setEstado(true);
		u2.setFechaApertura(17, 6, 2021);
		u2.setNacimiento(12, 7, 1990);
		red.agregarCuenta(u2);
		Cuenta u3 = new CuentaNormal();
		u3.setNombreUsuario("User3");
		u3.setMail("user3@gmail.com");
		u3.setEstado(true);
		u3.setFechaApertura(17, 6, 2021);
		u3.setNacimiento(20, 12, 2000);
		red.agregarCuenta(u3);
		Cuenta u4 = new CuentaNormal();
		u4.setNombreUsuario("User4");
		u4.setMail("user4@gmail.com");
		u4.setEstado(true);
		u4.setFechaApertura(17, 6, 2021);
		u4.setNacimiento(1, 3, 2002);
		red.agregarCuenta(u4);
		Cuenta u5 = new CuentaNormal();
		u5.setNombreUsuario("User5");
		u5.setMail("user5@gmail.com");
		u5.setEstado(true);
		u5.setFechaApertura(17, 6, 2021);
		u5.setNacimiento(6, 7, 1997);
		red.agregarCuenta(u5);
		Cuenta p1 = new CuentaFamoso();
		p1.setNombreUsuario("Pop1");
		p1.setMail("pop1@gmail.com");
		p1.setEstado(true);
		p1.setFechaApertura(17, 6, 2021);
		p1.setNacimiento(19, 8, 1998);
		red.agregarCuenta(p1);
		Cuenta p2 = new CuentaFamoso();
		p2.setNombreUsuario("Pop2");
		p2.setMail("pop2@gmail.com");
		p2.setEstado(true);
		p2.setFechaApertura(17, 6, 2021);
		p2.setNacimiento(5, 4, 1990);
		red.agregarCuenta(p2);
		Cuenta p3 = new CuentaFamoso();
		p3.setNombreUsuario("Pop3");
		p3.setMail("pop3@gmail.com");
		p3.setEstado(true);
		p3.setFechaApertura(17, 6, 2021);
		p3.setNacimiento(27, 2, 2000);
		red.agregarCuenta(p3);
		Cuenta e1 = new CuentaEmpresa();
		e1.setNombreUsuario("Empresa1");
		e1.setMail("Empresa1@gmail.com");
		e1.setEstado(true);
		e1.setFechaApertura(17, 6, 2021);
		e1.setNacimiento(2, 4, 1975);
		if (e1 instanceof CuentaEmpresa) {
			((CuentaEmpresa) e1).setDireccionEmpresa("Av Santa Fe 2134");
			((CuentaEmpresa) e1).setMailEmpresa("empresa1@gmail.com");
			((CuentaEmpresa) e1).setTelefonoEmpresa(1166498454);
		}
		red.agregarCuenta(e1);
		Cuenta e2 = new CuentaEmpresa();
		e2.setNombreUsuario("Empresa2");
		e2.setMail("Empresa1@gmail.com");
		e2.setEstado(true);
		e2.setFechaApertura(17, 6, 2021);
		e2.setNacimiento(3, 4, 1956);
		if (e2 instanceof CuentaEmpresa) {
			((CuentaEmpresa) e2).setDireccionEmpresa("Guemes 943");
			((CuentaEmpresa) e2).setMailEmpresa("empresa2@gmail.com");
			((CuentaEmpresa) e2).setTelefonoEmpresa(1138920468);
		}
		red.agregarCuenta(e2);
		u1.seguir(u1, u2);
		u1.seguir(u1, e2);
		u1.seguir(u1, p3);
		u2.seguir(u2, e2);
		u2.seguir(u2, p1);
		u3.seguir(u3, p1);
		u3.seguir(u3, e1);
		u3.seguir(u3, u4);
		u4.seguir(u4, u3);
		u4.seguir(u4, u5);
		u4.seguir(u4, p2);
		u5.seguir(u5, e1);
		u5.seguir(u5, p3);
		u5.seguir(u5, p2);
		p1.seguir(p1, e2);
		p1.seguir(p1, e1);
		p2.seguir(p2, e1);
		p3.seguir(p3, p1);
		p3.seguir(p3, e2);
		p3.seguir(p3, e1);
		List<String> etiquetados = new ArrayList<String>();
		Publicaciones publicacion1 = new Publicaciones();
		publicacion1.crearPublicacion(e1, red, 18, 6, 2021, "Hola, soy empresa 1", true, etiquetados, true);
		e1.publicar(publicacion1);
		Publicaciones publicacion2 = new Publicaciones();
		publicacion2.crearPublicacion(e1, red, 19, 6, 2021, "Hola, aca de nuevo empresa 1", true, etiquetados, false);
		e1.publicar(publicacion2);
		Publicaciones publicacion3 = new Publicaciones();
		publicacion3.crearPublicacion(e2, red, 20, 6, 2021, "Hola, soy empresa 2", true, etiquetados, true);
		e2.publicar(publicacion3);
		Publicaciones publicacion4 = new Publicaciones();
		publicacion4.crearPublicacion(e2, red, 21, 6, 2021, "Hola, aca de nuevo empresa2", false, etiquetados, true);
		e2.publicar(publicacion4);
		Publicaciones publicacion5 = new Publicaciones();
		etiquetados.add("Pop2");
		publicacion5.crearPublicacion(p1, red, 22, 6, 2021, "Hola, soy Pop1 amiga de @Pop2", true, etiquetados, true);
		p1.publicar(publicacion5);
		p2.republicar(publicacion5, red);
		etiquetados.clear();
		etiquetados.add("User3");
		etiquetados.add("User4");
		etiquetados.add("Pop1");
		Publicaciones publicacion6 = new Publicaciones();
		publicacion6.crearPublicacion(u2, red, 30, 6, 2021,"Que bueno estar con @User3 y @User 4 viendo a @Pop1", true, etiquetados, false);
		u2.publicar(publicacion6);
		u1.likear(publicacion6);
		u3.likear(publicacion6);
		u4.likear(publicacion6);
		Scanner teclado = new Scanner(System.in);
		System.out.println("Bienvenido a la red social. \n");
		System.out.println("Cuentas:");
		red.mostrarCuentas();
		int res;
		System.out.println("\nPresione el numero de la cuenta a seleccionar.");
		res = teclado.nextInt();
		while (res < 0 || res > 9 ) {
			System.out.println("Error, el numero introducido no esta asociado a ninguna cuenta. Por favor reintente.");
			System.out.println("Presione el numero de la cuenta a seleccionar.");
			res = teclado.nextInt();
		}
		Cuenta seleccionada = red.cuentas.get(res);
		System.out.println("Usted selecciono: " + seleccionada.getNombreUsuario());
		System.out.println("\nPresione: \n 1 para ver la pizarra \n 2 para ver su feed \n 3 para realizar una publicacion \n 4 para ver la informacion de la cuenta \n 5 para ver el alcance de la cuenta \n 6 para activar/suspender la cuenta \n 7 para seleccionar otra cuenta \n 8 para salir de la red social");
		res = teclado.nextInt();
		while (res < 1 || res > 8) {
			System.out.println("Error, el numero introducido no corresponde a ninguna accion. Por favor reintente.");
			System.out.println("Presione: \n 1 para ver la pizarra \n 2 para ver su feed \n 3 para realizar una publicacion \n 4 para ver la informacion de la cuenta \n 5 para ver el alcance de la cuenta \n 6 para activar/suspender la cuenta \n 7 para seleccionar otra cuenta \n 8 para salir de la red social");
			res = teclado.nextInt();
		}
		while (res != 8) {
			if (res == 1) {
				seleccionada.verPizarra();
				if (seleccionada.getSizePizzara() > 0) {
						System.out.println("Presione el numero de la publicacion a elegir o -1 para volver al menu.");
						res = teclado.nextInt();
						while (res < -1 || res >= seleccionada.getSizePizzara()) {
							System.out.println("Error, el numero introducido no pertenece a ninguna publicacion. Por favor reintente.");
							System.out.println("Presione el numero de la publicacion a elegir o -1 para volver al menu.");
							res = teclado.nextInt();
						}
						if (res != -1) {
							Publicaciones pub = seleccionada.getPublicacionPizzara(res);
							System.out.println("Presione 1 para likear la publicacion o 2 para republicarla.");
							res = teclado.nextInt();
							while (res < 1 || res > 2) {
								System.out.println("Error, el numero introducido no pertenece a ninguna accion a realizar. Por favor reintente");
								System.out.println("Presione 1 para likear la publicacion o 2 para republicarla.");
								res = teclado.nextInt();
							}
							if (res == 1) {
								seleccionada.likear(pub);
							}else {
								seleccionada.republicar(pub, red);
							}
						}
					}
			}else{
				if (res == 2) {
					seleccionada.verFeed();
				}else {
					if (res == 3) { 
						if (seleccionada.getEstado() == true) {
							Publicaciones nueva = new Publicaciones();
							nueva.crearPublicacion(seleccionada, red);
							seleccionada.publicar(nueva);
						}else {
							System.out.println("Error. La cuenta no puede realizar publicaciones ya que esta suspendida.\n");
						}
					}else {
						if (res == 4) {
							System.out.println("Informacion cuenta:");
							if (seleccionada instanceof CuentaEmpresa) {
								((CuentaEmpresa) seleccionada).mostrarDatosCuentaEmpresa();
							}else {
								if (seleccionada instanceof CuentaFamoso) {
									seleccionada.mostrarDatosCuenta();
									((CuentaFamoso) seleccionada).mostrarDatosFamoso();
								}else {
									if (seleccionada instanceof CuentaNormal) {
										seleccionada.mostrarDatosCuenta();
										((CuentaNormal) seleccionada).mostrarDatosCuentaNormal();
									}
								}
							System.out.println("\n");	
							}
						}else {	
							if (res == 5) {
								System.out.println( "Alcance de " + seleccionada.getNombreUsuario() + " : "  + seleccionada.alcanceCuenta(seleccionada) + " cuentas. \n");
							}else {
								if (res == 6) {
									System.out.println("1 para activar cuenta, 2 para suspender cuenta.");
									res = teclado.nextInt();
									while (res < 1 || res > 2) {
										System.out.println("Error, el numero introducido no pertenece a ninguna accion a realizar. Por favor reintente");
										System.out.println("1 para activar cuenta, 2 para suspender cuenta.");
										res = teclado.nextInt();
									}
									if (res ==1) {
										seleccionada.setEstado(true);
									}else {
										seleccionada.setEstado(false);
									}
								}else {
									if (res == 7) {
										System.out.println("\nCuentas: ");
										red.mostrarCuentas();
										System.out.println("\nPresione el numero de la cuenta a seleccionar.");
										res = teclado.nextInt();
										while (res < 0 || res > 9 ) {
											System.out.println("Error, el numero introducido no esta asociado a ninguna cuenta. Por favor reintente.");
											System.out.println("Presione el numero de la cuenta a seleccionar.");
											res = teclado.nextInt();
										}
										seleccionada = red.cuentas.get(res);
										System.out.println("Usted selecciono: " + seleccionada.getNombreUsuario());
									}
								}
							}
						}
					}
				}
			}
			System.out.println("Presione: \n 1 para ver la pizarra \n 2 para ver su feed \n 3 para realizar una publicacion \n 4 para ver la informacion de la cuenta \n 5 para ver el alcance de la cuenta \n 6 para activar/suspender la cuenta \n 7 para seleccionar otra cuenta \n 8 para salir de la red social");			res = teclado.nextInt();
			while (res < 1 || res > 8) {
				System.out.println("Error, el numero introducido no corresponde a ninguna accion. Por favor reintente.");
				System.out.println("Presione: \n 1 para ver la pizarra \n 2 para ver su feed \n 3 para realizar una publicacion \n 4 para ver la informacion de la cuenta \n 5 para ver el alcance de la cuenta \n 6 para activar/suspender la cuenta \n 7 para seleccionar otra cuenta \n 8 para salir de la red social");				res = teclado.nextInt();
			}
		}
		System.out.println("FIN PROGRAMA");
		teclado.close();
	}
}