package search;

import java.util.Comparator;

public class GreedNodeComparator implements Comparator<TreeNode> {

	@Override
	public int compare(TreeNode o1, TreeNode o2) {
		return o1.getState().eval().compareTo(o2.getState().eval());
	}

}
