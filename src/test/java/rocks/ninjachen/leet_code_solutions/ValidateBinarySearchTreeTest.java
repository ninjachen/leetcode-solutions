package rocks.ninjachen.leet_code_solutions;

import org.junit.Before;
import org.junit.Test;
import rocks.ninjachen.util.ResourceUtil;
import rocks.ninjachen.util.TreeNode;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {
    ValidateBinarySearchTree solution;

    @Before
    public void setUp() throws Exception {
        solution = new ValidateBinarySearchTree();
    }

    @Test
    public void isValidBST() {
        TreeNode root = ResourceUtil.parseTreeNode("[3,1,5,0,2,4,6]");
        assertEquals(true, solution.isValidBST(root));
    }

    @Test
    public void testcase2() {
        TreeNode root = ResourceUtil.parseTreeNode("[10,5,15,null,null,6,20]");
        assertEquals(false, solution.isValidBST(root));
    }

}