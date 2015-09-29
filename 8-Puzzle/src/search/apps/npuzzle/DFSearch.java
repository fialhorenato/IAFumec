package search.apps.npuzzle;

import java.util.ArrayList;

public class DFSearch {
	
	public static void printSolution(Solution sol)
	{
		PuzzleAction a;
		while ( (a = (PuzzleAction)sol.getNextAction()) != null)
		{
			switch (a.getAction())
			{
				case UP:
					System.out.println("CIMA");
					break;
					
				case DOWN:
					System.out.println("BAIXO");
					break;
					
				case LEFT:
					System.out.println("ESQUERDA");
					break;
					
				case RIGHT:
					System.out.println("DIREITA");
					break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		System.out.println("Resolvendo com Busca em Profundidade");
		System.out.println();
		
		GraphSearch search = new GraphSearch();
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);a.add(2);a.add(4);
		a.add(7);a.add(5);a.add(3);
		a.add(8);a.add(1);a.add(6);
		
		PuzzleState state = new PuzzleState(a);
		
		state.print(System.out);
		
		PuzzleProblem problem = new PuzzleProblem(state);
		
		Fringe  fringe = new Stack();
		long start = System.nanoTime();
		Solution sol = search.execute(problem, fringe, 0);
		long end = System.nanoTime();
		
		printSolution(sol);
		
		System.out.println();
		
		System.out.println("Tempo de Busca: " + (double)(end - start) / 1E9 + " s");
		System.out.println("Nós Gerados: " + problem.getNumCopies());
		System.out.println("Profundidade da Solução: " + sol.getCost());
		System.out.println();

		
	}

}
