import apple.laf.JRSUIUtils;

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private Object data;

    public TreeNode() {
        this.left = null;
        this.right = null;
    }

    public TreeNode(Object data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public void addLeftChild(TreeNode node) {
        this.left = node;
    }

    public void addRightChild(TreeNode node) {
        this.right = node;
    }

    public TreeNode getLeftChild() {
        return this.left;
    }

    public TreeNode getRightChild() {
        return this.right;
    }


    public static int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        } else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }

    }

    public static boolean isBalanced(TreeNode node) {

        if (node == null) return true;

        int heightDifference = getHeight(node.left)-getHeight(node.right);
        if (Math.abs(heightDifference) > 1) {
            return false;
        } else {
            return isBalanced(node.left) && isBalanced(node.right);
        }
    }

    public static TreeNode createMinBST(int[] input, int start, int end) {

        //Base case
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode n = new TreeNode(input[mid]);

        n.left = createMinBST(input, start, mid-1);
        n.right = createMinBST(input, mid+1, end);

        return n;
    }


}
