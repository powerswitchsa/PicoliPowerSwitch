package utilesglobal;

import java.util.Random;

public class Utilies {

	public static int obtenerAleatorio(int max) {
		return new Random().nextInt(max + 1);
	}

	public static int obtenerAleatorio(int min, int max) {
		return min + obtenerAleatorio(max - min);
	}

	public static String getNombreAleatorio() {
		String nombre = "";
		boolean cambio = true;
		int logitud = obtenerAleatorio(4, 8);
		for (int i = 0; i < logitud; i++) {
			if (cambio) {
				nombre += String.valueOf(getConsonante());
				cambio = false;
			} else {
				nombre += String.valueOf(getVocal());
				cambio = true;
			}
		}
		return nombre;
	}

	private static char getVocal() {
		int[] vocales = { 97, 101, 105, 111, 117 };
		return (char) vocales[obtenerAleatorio(vocales.length - 1)];
	}

	private static char getConsonante() {
		int consonante = 0;
		do {
			consonante = obtenerAleatorio(97, 122);
		} while (isVocal(consonante));
		return (char) consonante;
	}

	private static boolean isVocal(int ascii) {
		int[] vocales = { 97, 101, 105, 111, 117 };
		for (int i = 0; i < vocales.length; i++) {
			if (ascii == vocales[i]) {
				return true;
			}
		}
		return false;
	}
}
