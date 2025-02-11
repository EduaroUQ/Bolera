/**
 * 
 */
package versión3;

/**
 * 
 */
public class Jugador3 {
	//Se crea los atributos de la clase
	String nombre;
	int[] resultadoNumerico;
	String[] resultadoTexto;

	//Se genera el constructor de la clase teniendo como parámetro el nombre 
	public Jugador3(String nombre) {
		this.nombre = nombre;
		this.resultadoNumerico = new int[PartidaBolos3.NUMERO_DE_RONDAS];
		this.resultadoTexto = new String[PartidaBolos3.NUMERO_DE_RONDAS];
	}

	//Se crean los getters y setters de la clase
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getResultadoNumerico() {
		return resultadoNumerico;
	}

	public void setResultadoNumerico(int[] resultadoNumerico) {
		this.resultadoNumerico = resultadoNumerico;
	}
	
	//Se crean los métodos de la clase que se ejecutarán en el main

	/**
	 * Este método realiza una tirada obteniendo un número aleatorio entre 0 y 10, actualizanado el resultado del turno e imprimiendo la puntuación que se hizo.
	 * En caso de que la puntuación sea 10 será considerado un pleno y se guardará con "X" en la posición correspondiente en el array de Texto.
	 * Si la puntuación es menor que 10 se realizará otra tirada con un rango disponible de los bolos que queden y se guardará la suma de ambas tiradas en el array númerico
	 * En caso de que la suma sea igual a 10 será un semipleno representado con un"/" en el array de Texto, sino solo será un "-"
	 * @param tirada posición del turno que le toca.
	 */
	public void jugarTurno(int tirada) {
		int punto1 = (int) (Math.random() * 11);
		resultadoNumerico[tirada] = punto1;
		System.out.println("Primera tirada de " + nombre + "." + " Tira " + punto1 + " de 10 bolos");
		if (punto1 < 10) {
			int punto2 = (int) (Math.random() * (11 - punto1));
			resultadoNumerico[tirada] = punto1 + punto2;
			System.out.println("Segunda tirada de " + nombre + "." + " Tira " + punto2 + " de " + (10 - punto1) + " bolos");
			if (resultadoNumerico[tirada] < 10) {
				resultadoTexto[tirada] = "-";
			} else if (resultadoNumerico[tirada] == 10) {
				resultadoTexto[tirada] = "/ ";
				System.out.println("¡" + nombre + " ha hecho un semipleno!");
			}
			System.out.println(nombre+" ha obtenido una puntuación de "+(punto1+punto2));
		} else if (punto1 == 10) {
			resultadoNumerico[tirada] = punto1;
			resultadoTexto[tirada] = "X ";
			System.out.println("¡" + nombre + " ha hecho un pleno!");
			System.out.println(nombre+" ha obtenido una puntuación de "+punto1);
		}	
	}

	/**
	 * Este método realiza la última tirada de la partida donde el primer tiro será entre un número aleatorio entre 0 y 10, actualizanado el resultado del turno e imprimiendo la puntuación que se hizo.
	 * Si la primera tirada es menor a 10 se tirará de nuevo pudiendo tirar como máximo el número de bolos restantes y la posición númerica será la suma de ambos tiros.
	 * En caso de que la suma de las dos primeras tiradas sea 10 se considerará un semipleno guardandose un "/" en el array en Texto.
	 * Si la primera tirada es 10, se realizarán dos tiros más  y la posición númerica será la suma de los tres tiros.
	 * Si la segunda tirada es menor a 10, la tercera solo podrá hacer como máximo el número de tiradas restantes de la segunda.
	 * En caso de que la suma de las tiradas dos y tres sumen 10 se considerará un semipleno guardandose un "X/" en el array en Texto, sino será "X"
	 * Si la segunda tirada es 10, la tercerá podrá tirar como máximo 10 bolos, si logra darse el caso se guardará "XXX" en el array en Texto, sino será "XX"
	 * @param ultimatirada posición del último turno de la ronda
	 */
	public void jugarTurnoFinal(int ultimatirada) {
		int punto1 = (int) (Math.random() * 11);
		resultadoNumerico[ultimatirada] = punto1;
		System.out.println("Primera tirada de " + nombre + "." + " Tira " + punto1 + " de 10 bolos");
		if (punto1 < 10) {
			int punto2 = (int) (Math.random() * (11 - punto1));
			resultadoNumerico[ultimatirada] = punto1 + punto2;
			System.out.println("Segunda tirada de " + nombre + "." + " Tira " + punto2 + " de " + (10 - punto1) + " bolos");
			if (resultadoNumerico[ultimatirada] < 10) {
				resultadoTexto[ultimatirada] = "-";
			} else {
				resultadoTexto[ultimatirada] = "/ ";
				System.out.println("¡" + nombre + " ha hecho un semipleno!");
			}
			System.out.println(nombre+" ha obtenido una puntuación de "+(punto1+punto2));
		} else if (punto1 == 10) {
			System.out.println("¡" + nombre + " ha hecho un pleno!" + " Tiene 2 tiradas más.");
			int punto2 = (int) (Math.random() * 11);
			if (punto2 < 10) {
				int punto3 = (int) (Math.random() * (11 - punto2));
				resultadoNumerico[ultimatirada] = punto1 + punto2 + punto3;
				System.out.println("Segunda tirada de " + nombre + "." + " Tira " + punto2 + " de 10 bolos");
				System.out.println("Tercera tirada de " + nombre + "." + " Tira " + punto3 + " de " + (10 - punto2) + " bolos");
				if ((punto2 + punto3) == 10) {
					resultadoTexto[ultimatirada] = "X/";
					System.out.println("¡" + nombre + " ha hecho un semipleno!");
				} else {
					resultadoTexto[ultimatirada] = "X ";
				}
				System.out.println(nombre+" ha obtenido una puntuación de "+(punto1+punto2+punto3));
			} else if (punto2 == 10) {
				System.out.println("Segunda tirada de " + nombre + "." + " Tira " + punto2 + " de 10 bolos");
				System.out.println("¡" + nombre + " ha hecho un pleno!");
				int punto3 = (int) (Math.random() * (11));
				resultadoNumerico[ultimatirada] = punto1 + punto2 + punto3;
				resultadoTexto[ultimatirada] = "XX";
				System.out.println("Tercera tirada de " + nombre + "." + " Tira " + punto3 + " de 10 bolos");
				if (punto3 == 10) {
					resultadoTexto[ultimatirada] = "XXX";
					System.out.println("¡" + nombre + " ha hecho un pleno!");
				}
				System.out.println(nombre+" ha obtenido una puntuación de "+(punto1+punto2+punto3));
			}
		}
	}

	/**
	 * Este método calcula la puntuación total que un jugador hace al finalizar la partida recorriendo el array de números y sumando con un contador.
	 * En caso de que en la posición del array en Texto sea "/" este sumará 5 puntos adicionales.
	 * En caso de que en la posición del array en Texto sea "X" este sumará 10 puntos adicionales.
	 * En caso de que en la posición del array en Texto sea "X/" este sumará 15 puntos adicionales.
	 * En caso de que en la posición del array en Texto sea "XX" este sumará 20 puntos adicionales.
	 * En caso de que en la posición del array en Texto sea "XXX" este sumará 10 puntos adicionales.
	 * @return suma: Puntuación total
	 */
	public int calcularPuntuacion() {
		int suma = 0;
		for (int i = 0; i < resultadoNumerico.length; i++) {
			suma = suma + resultadoNumerico[i];
			if (resultadoTexto[i] == "/ ") {
				suma = suma + 5;
			} else if (resultadoTexto[i] == "X ") {
				suma += 10;
			} else if (resultadoTexto[i] == "X/") {
				suma += 15;
			} else if (resultadoTexto[i] == "XX") {
				suma += 20;
			} else if (resultadoTexto[i] == "XXX") {
				suma += 30;
			}
		}
		return suma;
	}

	/**
	 * Este método recorre el array de números e imprime los resultados obtenidos en cada ronda indicando la puntuación en la posición correspondiente.
	 * También imprime el array en texto de cada posición.
	 */
	public void mostrarPuntuación() {
		System.out.println("Resultados de "+nombre+"\n"+"-----------------------");
		System.out.print("|");
		for (int i = 0; i < resultadoNumerico.length; i++) {
			System.out.print(resultadoNumerico[i]+"|");
		}
		System.out.println(""+"\n"+"-----------------------");
		System.out.print("|");
		for (int i = 0; i < resultadoTexto.length; i++) {
			System.out.print(resultadoTexto[i]+"|");
		}
		System.out.println(""+"\n"+"-----------------------");
	}
}
