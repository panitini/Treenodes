package com.krian.tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import com.krian.node.Node;

/**
 * The Class TreeNodeTraverse.
 */
public class TreeNodeTraverse {

	/** The color array. */
	String[] colorArray = { "blue", "green", "yellow" };

	/** The k value for node increment */
	int k = 0;

	/** The r. */
	int r = 0;

	/** The list of color nodes as requested task 4 */
	ArrayList<Node> colorNodes;

	/** The root node */
	Node rndNodetemp;

	/** The set of color spots */
	String colorSpotSet = "";

	ArrayList<Node> nodeList;

	/**
	 * Creates the tree.
	 *
	 * @param levelsCount
	 *            the levels count
	 * @param minChildren
	 *            the min children for child nodes
	 * @param maxChildren
	 *            the max children for child nodes
	 * @return the node
	 */
	public Node createTree(int levelsCount, int minChildren, int maxChildren) {
		rndNodetemp = new Node(++k, colorArray[new Random().nextInt(colorArray.length)]);
		for (int i = 0; i < levelsCount; i++) {
			selectNode(rndNodetemp);
			Node nodewithBranches = addBranches(rndNodetemp, minChildren, maxChildren);
			rndNodetemp = nodewithBranches;
		}
		return rndNodetemp;
	}

	/**
	 * Select of node from Tree to add new branches
	 *
	 * @param snode
	 *            the snode
	 */
	private void selectNode(Node snode) {

		if (snode.getChilds() != null) {
			nodeSelection(snode);
		}
	}

	/**
	 * Node selection is called Select node
	 *
	 * @param snode
	 *            the snode
	 */
	private void nodeSelection(Node snode) {
		r++;
		Node[] branches = snode.getChilds();
		int nodeLengthtemp = branches.length;
		int rndNodeIdTemp = new Random().ints(1, 0, nodeLengthtemp).findFirst().getAsInt();
		rndNodetemp = branches[rndNodeIdTemp];
		if (rndNodetemp.getChilds() != null) {

			nodeSelection(rndNodetemp);
		}
	}

	/**
	 * Adds the branches to Selected Node
	 *
	 * @param selectedNode
	 *            the selected node
	 * @param minChildren
	 *            the min children
	 * @param maxChildren
	 *            the max children
	 * @return the node
	 */
	private Node addBranches(Node selectedNode, int minChildren, int maxChildren) {
		int nChild = new Random().ints(1, minChildren, maxChildren + 1).findFirst().getAsInt();
		selectedNode.addChilds(nChild);
		for (int j = 0; j < nChild; j++) {
			Node newNode = new Node(++k, colorArray[new Random().nextInt(colorArray.length)]);
			newNode.setParent(selectedNode);
			selectedNode.addchild(j, newNode);
		}
		for (int c = r; c > 0; c--) {
			if (selectedNode != null) {
				selectedNode = selectedNode.getParent();
			}
		}
		r = 0;
		return selectedNode;

	}

	/**
	 * traverse the tree
	 *
	 * @param root
	 *            the root
	 */
	private void traverse(Node root) {
		nodeList.add(root);
		Node[] childern = root.getChilds();
		if (childern != null) {
			for (Node node : childern) {

				traverse(node);
			}
		}
	}

	/**
	 * Write to the .dot file for requirement 3.
	 *
	 * @param file
	 *            the file
	 * @param root
	 *            the root
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public void writeUsingFiles(String file) {
		StringBuilder colorBuilder = new StringBuilder();
		StringBuilder treeBuilder = new StringBuilder();
		nodeList = new ArrayList<Node>();
		traverse(rndNodetemp);
		for (Node n : nodeList) {
			colorBuilder.append("\t" + "\"" + n.getNodeId() + "\"" + "[color=" + n.getColor() + "]\n");
			if (n.getNodeId() != 1) {
				treeBuilder.append("\n" + "\"" + n.getParent().getNodeId() + "\"->" + "\"" + n.getNodeId() + "\"");
			}
		}
		nodeList.clear();
		try {
			String diagraph = "digraph DotSampleTree {\n\t" + "node [style=filled];\n";
			String output = diagraph + colorBuilder.toString() + treeBuilder.toString() + "\n" + "}";
			Files.write(Paths.get(file), output.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * collection same color nodes which matched @param color . for requirement 4.
	 * 
	 * @param root
	 *            the root
	 * @param color
	 *            the color
	 * @return the array list --> return list as requested in the requirement 4.
	 */
	public ArrayList<Node> colorNodes(String color) {
		colorNodes = new ArrayList<Node>();
		nodeList = new ArrayList<Node>();
		traverse(rndNodetemp);
		for (Node n : nodeList) {
			if (n.getColor().equalsIgnoreCase(color)) {
				colorNodes.add(n);
			}
		}
		nodeList.clear();
		return colorNodes;
	}

	/**
	 * adding sizes of nodes= tree size
	 * 
	 * @return size --> return size
	 */
	public int treeSize() {
		int size = 0;
		nodeList = new ArrayList<Node>();
		traverse(rndNodetemp);
		for (Node n : nodeList) {
			size = n.getSize() + size;
		}
		nodeList.clear();
		return size;
	}

	/**
	 * extracting the color spots for requirement 5. color spot is a group of
	 * minimum 3 "inter-connected" nodes having the same color.
	 * 
	 * @param root
	 *            the root
	 * @return the string -> all color spots are concatenated into one string
	 *
	 */
	String colorNset = "";
	ArrayList<String> tempString = new ArrayList<String>();
	public String colorSpots(Node root) {

		if (root.getNodeId() == 1) {
			Node[] childernNode = root.getChilds();
			if (childernNode != null) {
				for (Node noder : childernNode) {
					colorSpots(noder);
				}
			}
		} else if (root.getNodeId() != 1) {
			Node[] childern = root.getChilds();
			if (childern != null) {
				for (Node node : childern) {
					if (root.getParent().getColor().equalsIgnoreCase(root.getColor())) {
						if (root.getColor().equalsIgnoreCase(node.getColor())) {
							colorNset = root.getParent().getColor() + " " + root.getParent().getNodeId() + " "
									+ root.getNodeId() + " " ;
							colorSpotSet = colorSpotSet + "\n" + colorNset+ node.getNodeId();
							recursiveColorSpots(node);
							for(String s:tempString) {
								colorSpotSet=colorSpotSet+"\n"+s;
							}
							tempString.clear();
						}
					}

					colorSpots(node);
				}
			}
		}
		
		
		return colorSpotSet;
	}

	

	
	int y=0;
	private void recursiveColorSpots(Node node) {
		
		
		
	

		Node[] childernNew = node.getChilds();
		if (childernNew != null) {
			y++;
			String paNode ="";
			Node tempNode= node;
			for (int t=0;t<y;t++) {
				if(tempNode!=null) {
					paNode=tempNode.getNodeId()+" "+paNode;
					tempNode=tempNode.getParent();
				}
				
			}
          
			for (Node nodeNew : childernNew) {
				if ((node.getColor().equalsIgnoreCase(nodeNew.getColor()))) {
					tempString.add(colorNset+ paNode+" " + nodeNew.getNodeId());
					recursiveColorSpots(nodeNew);

				}
			}
			y=0;
		}

	}

}
