/**
 * 
 */
package search;


/**
 * A class to store the solution of the problem
 * 
 * @author  ADJ LCM LCM
 * @version 1.0
 */
public class Solution {
	
	public enum Result {
		SOLUTION,
		FAIL,
		CUTOFF
	}

	private java.util.Stack<IAction> actions;
	private Result result = Result.FAIL;
	private Double cost = 0.0;
	
	/**
	 * The class constructor
	 * 
	 * @author  ADJ LCM LCM
	 * @version 1.0
	 */
	public Solution(TreeNode node, Result result)
	{
		this.result = result;
		if (node != null)
		{
			actions = new java.util.Stack<IAction>();
			cost = node.getCost();
			while (node.getParent() != null)
			{
				actions.push(node.getAction());
				node = node.getParent();
			}
		}
	}
	
	
	/**
	 * Returns if this solution is ok
	 * 
	 * @author  ADJ LCM LCM
	 * @version 1.0
	 * @return SOLUTION, FAIL, CUTTOFF
	 */
	public final Result GetResult()
	{
		return this.result;
	}
	
	/**
	 * Returns the actions to get to this solution
	 * 
	 * @author  ADJ LCM LCM
	 * @version 1.0
	 * @return an stack of actions
	 */
	public final java.util.Stack<IAction> GetActions()
	{
		return this.actions;
	}
	
	/**
	 * Sets the cost of the solution
	 * 
	 * @author  ADJ LCM LCM
	 * @version 1.0
	 * @param cost The cost of the Solution
	 */
	public final Double getCost()
	{
		return this.cost;
	}
}
