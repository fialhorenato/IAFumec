package search;

/**
 * Interface of the Actions. This interface should be implemented
 * according to the problem being solved.
 * 
 * @author  ADJ LCM LCM
 * @version 1.0
 */
public interface IAction {
	
	/**
	 * Gets the Cost of the action
	 * 
	 * @author  ADJ LCM LCM
	 * @return The cost of this action
	 */
	public Double getCost();

	
	/**
	 * Returns a label for the action
	 * 
	 * @author  ADJ LCM LCM
	 * @version 1.0
	 */
	public String toString();
}
