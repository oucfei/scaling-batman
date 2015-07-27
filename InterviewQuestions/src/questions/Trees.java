package questions;

import dataStructures.TreeNode;

public class Trees {
    public static boolean isBalanced(TreeNode root) {
    	System.out.println(maxDepth(root));
    	System.out.println(minDepth(root));
        return (maxDepth(root) - minDepth(root) <=1);
    }
    
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max( maxDepth(root.right), maxDepth(root.left) ) + 1;
    }
    
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.min( minDepth(root.left), minDepth(root.right) ) + 1;
    }
}
