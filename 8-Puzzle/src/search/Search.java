/**
 * 
 */
package search;

import java.util.*;

import search.Solution;


/**
 * Implements the algorithm for tree Search.
 * 
 * @author  ADJ LCM
 * @version 1.1
 */
public class Search {
	
	protected LinkedList<TreeNode> expand(SearchProblem problem, TreeNode thisNode)
	{
		LinkedList<IAction> actions = problem.getValidActions(thisNode.getState());
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		
		for (IAction a : actions)
		{
			TreeNode newNode = new TreeNode();
			newNode.setAction(a);
			newNode.setCost(thisNode.getCost() + a.getCost());
			newNode.setDeepness(thisNode.getDeepness()+1);
			newNode.setParent(thisNode);
			newNode.setState(problem.execute(thisNode.getState(), a));
			nodes.add(newNode);
		}
		
		return nodes;
	}
	
	
	/**
	 * Executes the search for the solution.
	 * 
	 * @author  ADJ LCM
	 * @version 1.0
	 * @param problem A {@link SearchProblem} object.
	 * @param fringe A {@link IFringe} object.
	 * @return A {@link Solution} object.
	 * 
	 */
	public Solution tree(SearchProblem problem, IFringe fringe, int maxDepth)
	{
		TreeNode newNode = new TreeNode();
		newNode.setAction(null);
		newNode.setCost(0.0);
		newNode.setDeepness(0);
		newNode.setParent(null);
		newNode.setState(problem.getInitialState());
		fringe.insert(newNode);

		Solution.Result result = Solution.Result.FAIL;
		
		while(!fringe.isEmpty())
		{
			
			TreeNode node = fringe.removeFirst();

			if (problem.isObjective(node.getState()))
			{
				return new Solution(node, Solution.Result.SOLUTION);
			}
			
			if (maxDepth > 0 && node.getDeepness() > maxDepth)
			{
				// at least one node has not been expanded
				// therefore cannot be sure that there is no solution
				// if none was found
				result = Solution.Result.CUTOFF;
				continue;
			}
			fringe.insert(expand(problem,node));
		}
		
		return new Solution(null, result);
	
	}
	
	
	public Solution graph(SearchProblem problem, IFringe fringe, int maxDepth)
	{
		TreeNode newNode = new TreeNode();
		newNode.setAction(null);
		newNode.setCost(0.0);
		newNode.setDeepness(0);
		newNode.setParent(null);
		newNode.setState(problem.getInitialState());
		fringe.insert(newNode);
		
		HashSet<IState> closed = new HashSet<IState>();

		Solution.Result result = Solution.Result.FAIL;
		
		while(!fringe.isEmpty())
		{
			
			TreeNode node = fringe.removeFirst();

			if (closed.contains(node.getState()))
			{
				TreeNode.nodesInMemory--;
				continue;
			}
				
			closed.add(node.getState());
			
			if (problem.isObjective(node.getState()))
			{
				return new Solution(node, Solution.Result.SOLUTION);
			}
			
			if (maxDepth > 0 && node.getDeepness() > maxDepth)
			{
				// at least one node has not been expanded
				// therefore cannot be sure that there is no solution
				// if none was found
				result = Solution.Result.CUTOFF;
				continue;
			}
			fringe.insert(expand(problem,node));
		}
		
		return new Solution(null, result);
	
	}
	
}
