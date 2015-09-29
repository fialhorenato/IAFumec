package org;

public class NRainhas {

	private static int[] x;
	private static int[] a;
	private static int _NumeroDeElementos = 20;
	private static int NumeroDeCombinacoes = 0;

	public static void main(String[] args) {

		a = new int[_NumeroDeElementos];
		for (int i = 1; i <= _NumeroDeElementos; i++)
			a[i - 1] = i;

		x = new int[0];
		long start = System.nanoTime();
		NRainhass(x, a);
		long end = System.nanoTime();
		System.out.println(((double) (end - start)) / 1E9 + " segundos");
		

		System.out.println();
		System.out.println("Combinações possiveis: " + NumeroDeCombinacoes);
		System.out.println();
	}

	public static void NRainhass(int[] x, int[] a)
    {
      if (x.length == a.length)
      {
        NumeroDeCombinacoes++;
       System.out.println(NumeroDeCombinacoes);
      }
      else
      {
        x = Realoca(x, x.length + 1);

        for(int item : a)
        {
          x[x.length -1] = item;

          if (Valido(x))
        	  NRainhass(x, a);
        }
      }
    }

	private static boolean Valido(int[] x) {
		int j = x.length - 1;

		for (int i = 0; i < x.length - 1; i++)
			if ((x[j] == x[i]) || (Math.abs(x[i] - x[j]) == Math.abs(i - j)))
				return false;

		return true;
	}

	private static int[] Realoca(int[] x, int size) {
		int[] temp = new int[size];
		for (int i = 0; i < x.length; i++)
			temp[i] = x[i];

		return temp;
	}

}
