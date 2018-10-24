package com.krian;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import com.krian.node.Node;
import com.krian.tree.TreeNodeTraverse;
import junit.framework.TestCase;


/**
 * The Class AppTest.
 */
public class AppTest extends TestCase {

	/** The node tree  */
	private TreeNodeTraverse tn;

	/**
	 * Instantiates a new app test.
	 *
	 * @param testName the test name
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() {
		tn = new TreeNodeTraverse();
		tn.createTree(7, 2, 5);
	}

	/**
	 * Test for requirement 4 with random color all notes colors are printed as
	 * well.
	 */
	@Test
	public void testApp() {
		String[] colorArray = { "blue", "yellow", "green" };
		String color = colorArray[new Random().nextInt(colorArray.length)];
		System.out.println("random color selected  - " + color);
		ArrayList<Node> list = tn.colorNodes(color);

		for (Node model : list) {
			assertEquals(color, model.getColor());
			System.out.println(model.getColor() + " - " + model.getNodeId());

		}

	}
}
