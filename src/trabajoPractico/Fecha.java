package trabajoPractico;
import java.util.Scanner;


public class Fecha {
		protected int dia;
		protected int mes;
		protected int año;
		
		public void mostrarFecha () {
			System.out.println(this.dia + "/" + this.mes + "/" + this.año);
		}
		public void insertarFecha () {
			Scanner teclado = new Scanner (System.in);
			System.out.println("Ingrese dia ");
			int entrada = teclado.nextInt();
			this.dia = entrada;
			System.out.println("Ingrese mes");
			entrada = teclado.nextInt();
			this.mes = entrada;
			System.out.println("Ingrese año");
			entrada = teclado.nextInt();
			this.año = entrada;
		}
		public int getDia () {
			return this.dia;
		}
		public int getMes () {
			return this.mes;
		}
		public int getAño() {
			return this.año;
		}
		
		
		private int cantDias(int m, int a) {
			if (m == 1 || m == 3 || m == 5 || m== 7 || m ==8 || m == 10 || m==12) {
				return 31;
			}
			if (m == 4 || m == 6 || m== 9 || m == 11) {
				return 30;
			}
			if (m == 2) {
				if (a % 4 == 0) {
					return 29;
				}else {
					return 28;
				}
			}
			return 0;
		}
		
		 
		public boolean validarFecha (Fecha f) {
				if (f.mes > 12 || f.mes < 1) {
					System.out.println("Error, mes invalido. Por favor reintente.\n");
					return false;
				}else {
					if (f.dia > this.cantDias(f.mes,f.año) || f.dia < 1) {
						System.out.println("Error, dia invalido. Por favor reintente\n");
						return false;
					}else {
						return true;
					}
				}
		}
		public boolean fechaMayor (Fecha f1, Fecha f2) {	//Devuelve si la primera fecha es mayor a la segunda
			if (f1.año > f2.año) {
				return true;
			}else {
				if (f1.año < f2.año) {
					return false;
				}else {
					if (f1.mes > f2.mes) {
						return true;
					}else {
						if (f1.mes < f2.mes) {
							return false;
						}else {
							if (f1.dia > f2.dia) {
								return true;
							}else {
								return false;
							}
						}
					}
				}
			}
		}
}
