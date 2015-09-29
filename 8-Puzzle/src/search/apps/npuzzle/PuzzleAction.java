package search.apps.npuzzle;

public class PuzzleAction implements Action {

	
	PuzzleState.Movement m_action;
	
	public void setAction(PuzzleState.Movement action)
	{
		m_action = action;
	}
	
	public PuzzleState.Movement getAction()
	{
		return m_action;
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 1;
	}

}
