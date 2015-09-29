package search.apps.npuzzle;

import java.util.ArrayList;

public class PuzzleProblem implements SearchProblem {

	private PuzzleState state;
	private int copies = 0;
	
	public PuzzleProblem(int size)
	{
		state = new PuzzleState(size);
	}
	
	public PuzzleProblem(PuzzleState state)
	{
		this.state = state.copy();
	}
	
	@Override
	public boolean isObjective(State state) throws ClassCastException {
		return ((PuzzleState)state).isObjective();
	}

	@Override
	public State getInitialState() throws ClassCastException {
		
		return state;
	}

	@Override
	public ArrayList<Successor> getSuccessor(State state)
			throws ClassCastException {

		ArrayList<Successor> successors = new ArrayList<Successor>();
		
		for (PuzzleState.Movement m : PuzzleState.Movement.values()) 
		{
			if (((PuzzleState)state).checkMove(m))
			{
				PuzzleState n = ((PuzzleState)state).copy();
				++copies;
				n.move(m);
				PuzzleAction a = new PuzzleAction();
				a.setAction(m);
				Successor s = new Successor();
				s.setAction(a);
				s.setState(n);
				
				successors.add(s);
			}
		}
		
		return successors;
	}

	
	public int getNumCopies()
	{
		return copies;
	}
}
