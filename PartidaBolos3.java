/**
 * 
 */
package versión3;

import java.util.Scanner;

/**
 * @author Eduardo Utrilla
 */
public class PartidaBolos3 {
	public static final int NUMERO_DE_RONDAS = 10;
	public static int record = 0;
	public static String nombreRecord = "";
	public static int[] HOFPuntuaciones = { 0, 0, 0 };
	public static String[] HOFNombres = { "", "", "" };
	public static boolean repetir = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¡BIENVENIDO AL JUEGO DE BOLOS!");

		do { //Se usa el bucle do while para repetir el juego en caso el usuario responda con una "N"
			System.out.println("Introduce el  nombre del primer jugador");
			String nombre1 = sc.nextLine();
			System.out.println("Introduce el  nombre del segundo jugador");
			String nombre2 = sc.nextLine();
			System.out.println("PULSA ENTER PARA CONTINUAR");
			sc.nextLine();

			Jugador3 jugador1 = new Jugador3(nombre1); //Se inicializan los objetos llamando a la clase Jugador
			Jugador3 jugador2 = new Jugador3(nombre2);
			System.out.println("¡EMPIEZA EL JUEGO!");
			for (int i = 0; i < ((NUMERO_DE_RONDAS) - 1); i++) { //Se realiza un for para iniciar las rondas de la partida
				System.out.println("------RONDA " + (i + 1) + "------");
				jugador1.jugarTurno(i); //Se pone como parámetro la posición del array que se quiere obtener
				System.out.println();
				jugador2.jugarTurno(i);
				System.out.println("PULSA ENTER PARA CONTINUAR");
				sc.nextLine();
			}
			System.out.println("------ÚLTIMA RONDA------");
			jugador1.jugarTurnoFinal((NUMERO_DE_RONDAS) - 1);
			System.out.println();
			jugador2.jugarTurnoFinal((NUMERO_DE_RONDAS) - 1);
			System.out.println("PULSA ENTER PARA CONTINUAR");
			sc.nextLine();

			jugador1.mostrarPuntuación();
			int suma1 = jugador1.calcularPuntuacion(); //Se usa la variable suma1 para inicializar el método calcularPuntuación.
			System.out.println("La puntuación total de " + nombre1 + " es " + suma1 + "\n");
			jugador2.mostrarPuntuación();
			int suma2 = jugador2.calcularPuntuacion();
			System.out.println("La puntuación total de " + nombre2 + " es " + suma2 + "\n");

			if (suma1 > suma2) { //Se formula una comparación para determinar al ganador de la partida usando la puntación total de cada jugador.
				System.out.println("El ganador es " + nombre1);
				comprobarRecord(jugador1);
			} else {
				System.out.println("El ganador es " + nombre2);
				comprobarRecord(jugador2);
			}

			comprobarHallOfFame(jugador1, jugador2); //Se inicializa el método comprobarHallOfFame para ver si ambos jugadores obtienen una posición.

			System.out.println("\n" + "¿Quieres volver a jugar?(S/N)");
			String respuesta = sc.nextLine();
			if (respuesta.equals("S")) { //Se realiza un if en donde si la respuesta dada es "S" seguirá jugando en caso de que sea "N" se detendrá el juego.
				repetir = false;
			} else if (respuesta.equals("N")) {
				repetir = true;
				System.out.println("¡GRACIAS POR JUGAR!");
			}
		} while (repetir == false);
		sc.close();
	}

	/**
	 * El método comprobarRecord verifica si el ganador de cada partida ha realizado un récord respecto a las anteriores partidas
	 * Este método tiene como parámetro a un objeto de la clase Jugador, del cual obtendrá su nombre y la puntuación total
	 * Hace una comparación entre el record base/anterior y la puntuación total del objeto
	 * Si la puntuación del objeto es mayor que la del record, este pasa a ser el nuevo récord cambiando la puntuación y el nombre.
	 * @param ganador un objeto de la clase Jugador3
	 */
	public static void comprobarRecord(Jugador3 ganador) {
		int resultado = ganador.calcularPuntuacion();
		String nombganador = ganador.getNombre();
		if (resultado > record) {
			record = resultado;
			nombreRecord = nombganador;
			System.out.println("Nuevo record!! " + nombreRecord + " con " + record + " puntos" + "\n");
		}
	}

	/**
	 * El método comprobarHallOfFame verifica si cada jugador de la partida entra en el salón de la fama del juego.
	 * Este método tiene como parámetros a dos objetos de la clase Jugador, del cual obtendrá su nombre y la puntuación total.
	 * Primero se hace un bucle para recorrer las posiciones del array númerico de las 3 posiciones del salón de la fama iniciando por el 0, es decir el mayor.
	 * Si la puntuación del objeto es mayor que la posición que indica se ejecuta otro bucle que recorre las posiciones del array desde de la última a la primera.
	 * Y reemplaza el orden desde la última posición haciendo haciendo que el penultimo pase a ser el último y así sucesivamente.
	 * Luego se reemplaza la puntuación total del objeto por la posición en la que sea mayor.
	 * @param jugador1 Un objeto de la clase Jugador3
	 * @param jugador2 Un objeto de la clase Jugador3
	 */
	public static void comprobarHallOfFame(Jugador3 jugador1, Jugador3 jugador2) {
		System.out.println("-----El salón de la fama:-----");
		int resultado1 = jugador1.calcularPuntuacion(); //Se crea una variable para que tenga como valor el método de la puntuación total del objeto1
		String nombrejugador1 = jugador1.getNombre();	//Se crea una variable para que se obtenga el nombre del objeto1
		int resultado2 = jugador2.calcularPuntuacion();
		String nombrejugador2 = jugador2.getNombre();
		for (int i = 0; i < 3; i++) {
			if (resultado1 > HOFPuntuaciones[i]) {
				for (int j = 2; j > i; j--) {
					HOFPuntuaciones[j] = HOFPuntuaciones[j - 1];
					HOFNombres[j] = HOFNombres[j - 1];
				}
				HOFPuntuaciones[i] = resultado1;
				HOFNombres[i] = nombrejugador1;
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (resultado2 > HOFPuntuaciones[i]) {
				for (int j = 2; j > i; j--) {
					HOFPuntuaciones[j] = HOFPuntuaciones[j - 1];
					HOFNombres[j] = HOFNombres[j - 1];
				}
				HOFPuntuaciones[i] = resultado2;
				HOFNombres[i] = nombrejugador2;
				break;
			}
		}
		for (int i = 0; i < HOFPuntuaciones.length; i++) {
			System.out.println((i + 1) +"º PUESTO: " + HOFPuntuaciones[i] + " - " + HOFNombres[i]);
		}
	}
}
