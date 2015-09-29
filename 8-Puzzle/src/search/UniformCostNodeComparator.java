package search;

import java.util.Comparator;

public class UniformCostNodeComparator implements Comparator<TreeNode> {

	@Override
	public int compare(TreeNode o1, TreeNode o2) {
		return o1.getCost().compareTo(o2.getCost());
	}

}
