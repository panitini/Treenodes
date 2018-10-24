package com.krian.tree;

import java.util.ArrayList;

import com.krian.node.Node;


/**
 * The Class RunDriver. for creating the Tree and executing 5 requirements
 */
public class RunDriver {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		/* Creating the Tree */
		TreeNodeTraverse treeNode = new TreeNodeTraverse();
		
		/* Requirement 2
		 *  generating a tree with L levels and  N random childs  between minChildren and maxChildren
		 *  Node createTree( int levelsCount, int minChildren, int maxChildren )
		 */
		Node root = treeNode.createTree(7, 2, 5);
				
		/* Requirement  3
		 * Creating a tree output sample as requested in Requirement 3
		 * Output sample is written to the input File provided in the below method call
		 * writeUsingFiles("FILE")
		 * Note: please make sure you have permissions to the file and folder 
		 */
		
			treeNode.writeUsingFiles("C:\\Work\\Tree.dot");
		
		 
		/* Retrieving the nodes by color in list as requested in Requirement 4
		 * List<Node> getNodesByColor(color)
		 * Note: Arraylist is printed out with sysout for verification nodes by color
		 */
		ArrayList<Node> list = treeNode.colorNodes("blue");
		for (Node model : list) {
			System.out.println(model.getColor() + " - " + model.getNodeId());
		}
		
		/* Retrieving the Colorspots as requested in Requirement 5
		 * String = colorSpots(Node);
		 * Note: String is printed out with sysout for verification of Color spots by color
		 */
		String colorSpots = treeNode.colorSpots(root);
		System.out.print("\n" + "Colorspots" + "\n" + colorSpots);
		
		/* Retrieving the size of Tree
		 * int = treesize(Node);
		 * Note: int is printed out with sysout for verification of size of tree
		 */
		int size = treeNode.treeSize();
		System.out.print("\n" + "Treesize" + "\n" + size);

	}

}
