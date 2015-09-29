package org;

public class Permutacao {
	
	// Número de elementos da permutação
	private static final int elementos = 10;
	
	// Contador do número de permutações
	private static int permutacont = 0;
	
	// Array que guarda as permutações
	private static int[] permutarray;
	
	// Array de inteiros
	private static int[] intarray;
	

	public static void main(String[] args) {
		intarray = new int[elementos];
		for (int i = 1; i <= elementos; i++) {
			intarray[i - 1] = i;
		}
		permutarray = new int[intarray.length];
		Permuta(intarray, 0);
		System.out.println("Permutações: " + permutacont);

	}
	
	
	// Função permuta, assim como no slide.
	public static void Permuta(int[] array, int n) {
		if (n == array.length) {
			permutacont++;
			Print();
		} else {
			for (int i = 0; i < array.length; i++) {
				if (!Valido(i, n)) {
					permutarray[n] = array[i];
					Permuta(array, n + 1);
				}
			}
		}
	}
	
	// Função valida, assim como no slide.
	public static boolean Valido(int i, int n) {
		for (int j = 0; j < n; j++)
			if (permutarray[j] == intarray[i])
				return true;
		return false;
	}
	
	// Função auxiliar que imprime os resultados
	public static void Print() {
		for (int i = 0; i < permutarray.length; i++)
			System.out.print(permutarray[i] + " ");
			System.out.println();
	}
}
