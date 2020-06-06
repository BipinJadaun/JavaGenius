package dataStructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dataStructures.models.TreeNode;

public class TraverseInOrder {

	public static void main(String[] args) {
		TreeNode root;
		
		root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);

        inOrderRecursive(root);
        System.out.println();
        inOrderIterative(root);
	}

	public static void inOrderRecursive(TreeNode root) {
		if(root == null)
			return;
		inOrderRecursive(root.left);
		System.out.print(root.val + " ");
		inOrderRecursive(root.right);
	}
	
	public static void inOrderIterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;
		
		while(true) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			else{
				if(stack.isEmpty()){
					break;
				}
				else {
					currentNode = stack.pop();
					System.out.print(currentNode.val + " ");
					currentNode = currentNode.right;
				}
			}				
		}
	}
	public static Object[] getInOrderInArray(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		traverseInOrderAndAddToList(root, list);
		return list.toArray();
	}

	private static void traverseInOrderAndAddToList(TreeNode root, List<Integer> list) {
		if(root == null)
			return;
		traverseInOrderAndAddToList(root.left, list);
		list.add(root.val);
		traverseInOrderAndAddToList(root.right, list);
	}

	public static void morrisInOrder(TreeNode root) {
		if(root == null)
			return;
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.val + " ");
				curr = curr.right;
			} else {
				TreeNode predecessor = curr.left;
				while(predecessor.right != null && predecessor.right != curr)
					predecessor = predecessor.right;

				if(predecessor.right != null) {
					predecessor.right = null;
					System.out.print(curr.val + " ");
					curr = curr.right;
				} else {
					predecessor.right = curr;
					curr = curr.left;
				}
			}
		}
	}
}
