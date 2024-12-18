/**
 * @author Qifei Wang
 * @version 1
 */

public class TreeNode {

    String data;
    TreeNode left;
    TreeNode right;

    /**
     * 
     * @param data data
     */

    public TreeNode(String data) {
        this.data = data;
    }

    /**
     * 
     * @return treeNode
     */

    public static TreeNode buildTree() {
        // YOUR CODE HERE
        TreeNode root = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");

        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = null;
        nodeC.left = null;
        nodeC.right = nodeG;
        nodeD.left = nodeE;
        nodeD.right = nodeF;
        nodeG.left = nodeH;
        nodeG.right = nodeI;

        return root;
    }
}
