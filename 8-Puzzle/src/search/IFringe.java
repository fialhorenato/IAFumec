/**
 * 
 */
package search;

import java.util.*; 

/**
 * Interface of the Fringe. This interface should be implemented
 * according to the data structure in use.
 * 
 * @author  ADJ LCM
 * @version 1.0
 */
public interface IFringe {

	/**
	 * Indicates of the data structure is empty
	 * 
	 * @author  ADJ LCM
	 * @return True if the data structure is empty. False otherwise.
	 */
	public boolean isEmpty();
	/**
	 * Returns the first node in the data structure
	 * 
	 * @author  ADJ LCM
	 * @return The first node in the data structure.
	 */
	public TreeNode getFirst();
	/**
	 * Returns the first node in the data structure and remove it
	 * 
	 * @author  ADJ LCM
	 * @return The first node in the data structure.
	 */
	public TreeNode removeFirst();
	/**
	 * Insert a node in the data structure
	 * 
	 * @author  ADJ LCM
	 * @param node The node to be inserted
	 */
	public void insert(TreeNode node);
	/**
	 * Insert a collection of nodes in the data structure
	 * 
	 * @author  ADJ LCM
	 * @param nodes The collection of nodes to be inserted
	 */
	public void insert(Collection<TreeNode> nodes);
	
}
