package com.krian.node;


/**
 * The Class Node.
 */
public class Node {

	/** The color. */
	String color;
	
	/** The node id. */
	int nodeId;
	
	/** Size */
	int size;
	
	/** The childs. */
	Node[] childs;
	
	/** The child. */
	Node child;
	
	/** The parent. */
	Node parent;

	/**
	 * Instantiates a new node.
	 */
	public Node() {

	}

	/**
	 * Instantiates a new node.
	 *
	 * @param Id the id
	 * @param Frabe the frabe
	 */
	public Node(int Id, String Frabe) {
		this.nodeId = Id;
		this.color = Frabe;
		this.parent = null;
		this.size=1;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Gets the node id.
	 *
	 * @return the node id
	 */
	public int getNodeId() {
		return nodeId;
	}

	/**
	 * Addchild.
	 *
	 * @param childId the child id
	 * @param nChild the n child
	 */
	public void addchild(int childId, Node nChild) {
		this.childs[childId] = nChild;

	}

	/**
	 * Adds the childs.
	 *
	 * @param nChilds the number of childs
	 * @return the node[]
	 */
	public Node[] addChilds(int nChilds) {
		childs = new Node[nChilds];
		return childs;

	}

	/**
	 * Sets the new parent.
	 *
	 * @param nParent the number of parents
	 * @return the node
	 */
	public Node setNewParent(Node nParent) {
		Node[] nNode = new Node[1];
		return nNode[0] = nParent;

	}

	/**
	 * Gets the childs.
	 *
	 * @return the childs nodes array
	 */
	public Node[] getChilds() {
		return childs;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}


}
