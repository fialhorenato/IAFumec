package search;

public class TreeNode{

	private TreeNode parent;
	private IAction action;
	private Integer deepness;
	private Double cost;
	private IState state;
	public static Integer nodesInMemory = 0;
	private static Integer maxNodesInMemory = 0;
	private static Integer generatedNodes = 0;
	private Integer uniqueId;
	
	public static final Integer getMaxNodesInMemory()
	{
		return maxNodesInMemory;
	}
	
	public static final Integer getGeneratedNodes()
	{
		return generatedNodes;
	}
	
	public final Integer getUniqueId()
	{
		return uniqueId;
	}
	
	public TreeNode()
	{
		uniqueId = generatedNodes++;
		
		if(++nodesInMemory > maxNodesInMemory)
			maxNodesInMemory = nodesInMemory;
	}
	
	protected void finalize() throws Throwable
	{
		--nodesInMemory;
		super.finalize();
	}
	
	
	protected void setParent(TreeNode parent)
	{
		this.parent = parent;
	}
	
	public final TreeNode getParent()
	{
		return this.parent;
	}
	
	protected void setAction(IAction action)
	{
		this.action = action;
	}
	
	public final IAction getAction()
	{
		return this.action;
	}
	
	protected void setCost(Double cost)
	{
		this.cost = cost;
	}
	
	public final Double getCost()
	{
		return this.cost;
	}
	
	protected void setDeepness(Integer deepness)
	{
		this.deepness = deepness;
	}
	
	public final Integer getDeepness()
	{
		return this.deepness;
	}
	
	protected void setState(IState state)
	{
		this.state = state;
	}
	
	public final IState getState()
	{
		return this.state;
	}

}
