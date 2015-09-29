/**
 * 
 */
package search;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Stack implementation of the Fringe Interface.
 * 
 * @author  ADJ LCM
 * @version 1.0
 */
public class Stack implements IFringe {

	LinkedList<TreeNode> nodes;
	/**
	 * Class Constructor
	 * 
	 * @author  ADJ LCM
	 */
	public Stack()
	{
		this.nodes = new LinkedList<TreeNode>();
	}
	/**
	 * Indicates of the data structure is empty
	 * 
	 * @author  ADJ LCM
	 * @return True if the data structure is empty. False otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return this.nodes.isEmpty();
	}
	/**
	 * Returns the first node in the data structure
	 * 
	 * @author  ADJ LCM
	 * @return The first node in the data structure.
	 */
	@Override
	public TreeNode getFirst() {
		return this.nodes.getLast();
	}
	/**
	 * Insert a node in the data structure
	 * 
	 * @author  ADJ LCM
	 * @param node The node to be inserted
	 */
	@Override
	public void insert(TreeNode node) {
		this.nodes.addLast(node);
	}
	/**
	 * Insert a collection of nodes in the data structure
	 * 
	 * @author  ADJ LCM
	 * @param node The node to be inserted
	 */
	@Override
	public void insert(Collection<TreeNode> nodes) {
		this.nodes.addAll(nodes);

	}
	/**
	 * Returns the first node in the data structure and remove it
	 * 
	 * @author  ADJ LCM
	 * @return The first node in the data structure.
	 */
	@Override
	public TreeNode removeFirst() {
		return this.nodes.pollLast();
	}

}
