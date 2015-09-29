package search;

import java.util.*;
/**
 * Interface of the Search Problem. This interface should be implemented
 * according to the problem being solved.
 * 
 * @author  ADJ LCM
 * @version 1.0
 */
public interface SearchProblem {
	/**
	 * Indicates if the state is an objective state. This function
	 * can be a simple comparison of states or it can be more complicated,
	 * detecting a property of the given state.
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 * @param state The state to be tested.
	 * @return True if this is an objective state. False otherwise.
	 */
	public boolean isObjective(IState state) throws ClassCastException;
	
	/**
	 * Returns the Initial state of the problem.
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 * @return The initial state.
	 */
	public IState getInitialState() throws ClassCastException;
	
	/**
	 * Returns the valid actions of the given state.
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 * @param state The state to be processed.
	 * @return A collection of successors of the given state.
	 */
	public LinkedList<IAction> getValidActions(IState state) throws ClassCastException;
	
	/**
	 * Returns the result of applying action over state
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 * @param state The state to be processed.
	 * @return A collection of successors of the given state.
	 */
	public IState execute(IState state, IAction action);
	
	
}
