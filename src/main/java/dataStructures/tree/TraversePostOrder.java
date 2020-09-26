package dataStructures.tree;

import java.util.Stack;

import dataStructures.models.TreeNode;

public class TraversePostOrder {

	public static void main(String[] args) {
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);
        
        postOrderRecursive(root);
        System.out.println();
        postOrderIterative(root);
	}

	public static void postOrderRecursive(TreeNode root) {
		if(root == null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.val + " ");
	}
	
	public static void postOrderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
	}

}
