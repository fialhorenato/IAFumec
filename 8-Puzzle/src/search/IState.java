/**
 * 
 */
package search;

/**
 * Interface of the state. This interface should be implemented
 * according to the problem being solved.
 * 
 * @author  ADJ LCM
 * @version 1.0
 */
public interface IState {
	
	/**
	 * Verify if an object is equals to this one 
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 * @param aThat An object
	 */
	public boolean equals(Object aThat);
	
	/**
	 * Returns the hashcode of this object 
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 */
	public int hashCode();
	
	
	/**
	 * Returns the heuristic function value for this state
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 */
	public Double eval();
	
	
	/**
	 * Returns a label for the state
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 */
	public String toString();

}
