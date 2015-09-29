package search.apps.npuzzle;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleState implements State {

	public enum Movement{
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
	protected Integer tabuleiro[][];
	private int emptyLine;
	private int emptyCol;
	protected final int EMPTY = 0;
	private int hType = 0;
	
	
	public PuzzleState(ArrayList<Integer> tab)
	{
		int size = (int) Math.floor(Math.sqrt(tab.size()));
		
		this.tabuleiro = new Integer[size][size];
		
		int index = 0;
		for (int i = 0; i < size;++i)
			for(int j = 0; j < size;++j)
			{
				tabuleiro[i][j] = tab.get(index++);
				if (tabuleiro[i][j] == 0)
				{
					emptyLine = i;
				    emptyCol = j;
				}
			}
	}
	
	public PuzzleState(int size)
	{
		int newSize = (int) Math.floor(Math.sqrt(size+1));
		this.tabuleiro = new Integer[newSize][newSize];
		java.util.ArrayList<Integer> shuffleArray = new java.util.ArrayList<Integer>();
		for (int i = 0; i < newSize*newSize; ++i)
			shuffleArray.add(i);
		
		while(true)
		{
			int N = 0;
			Collections.shuffle(shuffleArray);
			for (int i = 0; i < shuffleArray.size()-1; ++i)
				for(int j = i+1; j < shuffleArray.size(); ++j)
				{
					if (shuffleArray.get(i) > shuffleArray.get(j) && shuffleArray.get(j) != 0)
						++N;
				}
			if (N%2 == 0) break;
		}

		for (int i = 0; i < tabuleiro.length;++i)
			for(int j = 0; j < tabuleiro[i].length;++j)
			{
				tabuleiro[i][j] = shuffleArray.get(i*tabuleiro.length + j);
				if (tabuleiro[i][j] == EMPTY)
				{
					emptyLine = i;
				    emptyCol = j;
				}
			}
		
	}
	
	
	public final Integer getPosition(int line, int col)
	{
		
		return tabuleiro[line][col];
	}
	
	public boolean checkMove(Movement m){
		
		switch(m)
		{
			case UP: 
				if(emptyLine < tabuleiro.length - 1) return true;
				break;
				
			case DOWN:
				if(emptyLine > 0) return true;
				break;
				
			case LEFT:
				if(emptyCol < tabuleiro.length - 1) return true;
				break;
				
			case RIGHT:
				if(emptyCol > 0) return true;
				break;
		}
		
		return false;
	}
	
	public boolean move(Movement m)
	{
		if (!checkMove(m)) return false;
		
		Integer temp;
		
		switch (m)
		{
			case UP: 
				temp = tabuleiro[emptyLine+1][emptyCol];
				tabuleiro[emptyLine+1][emptyCol] = EMPTY;
				tabuleiro[emptyLine][emptyCol] = temp;
				++emptyLine;
				break;
				
			case DOWN:
				temp = tabuleiro[emptyLine-1][emptyCol];
				tabuleiro[emptyLine-1][emptyCol] = EMPTY;
				tabuleiro[emptyLine][emptyCol] = temp;
				--emptyLine;
				break;
				
			case LEFT:
				temp = tabuleiro[emptyLine][emptyCol+1];
				tabuleiro[emptyLine][emptyCol+1] = EMPTY;
				tabuleiro[emptyLine][emptyCol] = temp;
				++emptyCol;
				break;
				
			case RIGHT:
				temp = tabuleiro[emptyLine][emptyCol-1];
				tabuleiro[emptyLine][emptyCol-1] = EMPTY;
				tabuleiro[emptyLine][emptyCol] = temp;
				--emptyCol;
				break;
		}
		
		return true;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emptyCol;
		result = prime * result + emptyLine;
		result = prime * result + hType;
		for (int i = 0; i < tabuleiro.length; ++i)
			for (int j = 0; j < tabuleiro.length; ++j)
				result = prime * result + tabuleiro[i][j];
		
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuzzleState other = (PuzzleState) obj;
		if (emptyCol != other.emptyCol)
			return false;
		if (emptyLine != other.emptyLine)
			return false;
		if (hType != other.hType)
			return false;
		for (int i = 0; i < tabuleiro.length; ++i)
			for (int j = 0; j < tabuleiro.length; ++j)
				if (tabuleiro[i][j] != other.tabuleiro[i][j])
					return false;
		return true;
	}

	@Override
	public double eval() {
		if (hType == 0) return h1();
		else return h2();
	}

	
	private double h1() {
		int number = 1;
		int errors = 0;
		for (int i = 0; i < this.tabuleiro.length; ++i)
			for (int j = 0; j < this.tabuleiro.length; ++j)
			{
				if (number++ != tabuleiro[i][j]) ++errors;
				if (number >= tabuleiro.length*tabuleiro.length) break; 
			}
		return errors;
	}
	
	
	private double h2() {
		int value = 0;

		for (int i = 0; i < this.tabuleiro.length; ++i)
		{
			for (int j = 0; j < this.tabuleiro.length; ++j)
			{
				int number = this.tabuleiro[i][j];
				if (number == 0) continue;
				int linha = (int)Math.floor(((double)number-1.0)/ (double)this.tabuleiro.length);
				int coluna = (number-1) % this.tabuleiro.length;
				value += Math.abs(linha - i) + Math.abs(coluna - j);
			}
		}

		return value;
	}

	public void setHeuristic(int hType)
	{
		this.hType = hType;
	}
	
	public void print(PrintStream ps)
	{
		for(int i = 0; i < tabuleiro.length; ++i){
			for (int j = 0; j < tabuleiro.length; ++j){
				ps.printf("%4d ", tabuleiro[i][j]);
			}
			ps.println();
		}
		ps.println();
		
	}
	
	public boolean isObjective()
	{
		boolean ret = true;
		
		for (int i = 0; i < tabuleiro.length; ++i)
			for (int j = 0; j < tabuleiro.length; ++j)
				if (i == tabuleiro.length - 1 && j == i)
				{
					ret = (ret && (tabuleiro[i][j] == EMPTY));
				}else{
					ret = (ret && (tabuleiro[i][j] == i*tabuleiro.length + j + 1));
				}
		
		return ret;
	}
	
	public PuzzleState copy()
	{
		PuzzleState n = new PuzzleState(this.tabuleiro.length*this.tabuleiro.length);
		
		for (int i = 0; i < tabuleiro.length; ++i)
			for (int j = 0; j < tabuleiro.length; ++j)
				n.tabuleiro[i][j] = this.tabuleiro[i][j];
		
		n.emptyCol = this.emptyCol;
		n.emptyLine = this.emptyLine;
		n.hType = this.hType;
		
		return n;
	}
	
}
