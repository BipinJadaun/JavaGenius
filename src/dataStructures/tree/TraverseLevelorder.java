package dataStructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import dataStructures.models.TreeNode;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
 * https://www.geeksforgeeks.org/level-order-traversal-line-line-set-2-using-two-queues/
 */
public class TraverseLevelorder {

	public static void main(String[] args) {
		TreeNode root;
	  	  
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        root.left.left.right = new TreeNode(16);

        levelOrder(root);
        System.out.println();
        levelOrderInReverseOrder(root);
		System.out.println();
        levelOrderPrintOnDifferentLevelsWithTwoQueues(root);
        levelOrderPrintOnDifferentLevelsWithSingleQueue(root);

	}


	public static void levelOrder(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			System.out.print(tmp.val + " ");
			
			if(tmp.left != null) {
				queue.add(tmp.left);
			} 
			if(tmp.right != null) {
				queue.add(tmp.right);
			}
		}
		
	}

	private static void levelOrderInReverseOrder(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			stack.push(tmp);

			if(tmp.right != null)
				queue.add(tmp.right);
			if(tmp.left != null)
				queue.add(tmp.left);
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop().val + " ");
		}
	}

	public static void levelOrderPrintOnDifferentLevelsWithTwoQueues(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> queueParent = new LinkedList<>();
		Queue<TreeNode> queueChildren = new LinkedList<>();
		queueParent.add(root);
	
		while(!queueParent.isEmpty() || !queueChildren.isEmpty()) {
			TreeNode tmp = queueParent.poll();
			System.out.print(tmp.val + " ");
			if(tmp.left != null) {
				queueChildren.add(tmp.left);
			}
			if(tmp.right != null) {
				queueChildren.add(tmp.right);
			}
			
			if(queueParent.isEmpty()) {
				System.out.println();
				Queue<TreeNode> tmpQueue = queueChildren;
				queueChildren = queueParent;
				queueParent = tmpQueue;
			}
		}

	}
	
	public static void levelOrderPrintOnDifferentLevelsWithSingleQueue(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(true) {
			while(!queue.isEmpty()) {
				int numberOfNodesOnThisLevel = queue.size();
				while(numberOfNodesOnThisLevel-- > 0) {
					TreeNode tmp = queue.poll();
					System.out.print(tmp.val + " ");
					if(tmp.left != null)
						queue.add(tmp.left);
					if(tmp.right != null)
						queue.add(tmp.right);
				}
				System.out.println();
				if(queue.isEmpty())
					break;
				
			}
			
		}

	}
}
