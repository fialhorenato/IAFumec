package search;

import java.util.Comparator;

public class AStarNodeComparator implements Comparator<TreeNode> {

	@Override
	public int compare(TreeNode o1, TreeNode o2) {
		return new Double(o1.getCost() + o1.getState().eval()).compareTo(
							o2.getCost() + o2.getState().eval());
	}

}
