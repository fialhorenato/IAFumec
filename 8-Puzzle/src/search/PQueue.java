package search;

import java.util.*;

/**
 * Queue implementation of the Fringe Interface.
 * 
 * @author  ADJ LCM
 * @version 1.0
 */
public class PQueue implements IFringe {

	java.util.PriorityQueue<TreeNode> nodes;
	/**
	 * Class Constructor
	 * 
	 * @author  ADJ LCM
	 */
	public PQueue(Comparator<TreeNode> comparator)
	{
		this.nodes = new java.util.PriorityQueue<TreeNode>(11,comparator);
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
		return this.nodes.peek();
	}
	/**
	 * Insert a node in the data structure
	 * 
	 * @author  ADJ LCM
	 * @param node The node to be inserted
	 */
	@Override
	public void insert(TreeNode node) {
		this.nodes.add(node);
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
	 * Insert a collection of nodes in the data structure
	 * 
	 * @author  ADJ LCM
	 * @param nodes The collection of nodes to be inserted
	 */
	@Override
	public TreeNode removeFirst() {
		return this.nodes.poll();
	}

}
