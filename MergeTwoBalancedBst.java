package NewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBalancedBst {
	static class TreeNode {
		TreeNode left, right;
		int data;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	/*
	 * This function does the Inorder-Traversal and returns list!.
	 */
	public List<Integer> inOrderTraversal(TreeNode root, List<Integer> list) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				root = stack.pop();
				list.add(root.data);
				root = root.right;
			}
		}
		return list;
	}

	/*
	 * This function takes two arrays and merges into one big sorted array
	 */
	public List<Integer> mergeTwoArrays(List<Integer> a, List<Integer> b) {
		int[] answer = new int[a.size() + b.size()];
		int i = 0, j = 0, k = 0;

		while (i < a.size() && j < b.size()) {
			if (a.get(i) <= b.get(j)) {
				answer[k++] = a.get(i++);
			} else {
				answer[k++] = b.get(j++);
			}

		}

		while (i < a.size()) {
			answer[k++] = a.get(i++);
		}

		while (j < b.size()) {
			answer[k++] = b.get(j++);
		}

		a.clear();
		for (int m = 0; m < answer.length; m++) {
			a.add(answer[m]);
		}

		return a;
	}

	public TreeNode convertSortedListToTree(List<Integer> list) {

		return sortedArrayToBst(list, 0, list.size() - 1);
	}

	/*
	 * This function takes one sorted list and converts to binarySearchTree
	 */
	public TreeNode sortedArrayToBst(List<Integer> list, int start, int end) {
		if (list.size() == 0 || list == null || start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = sortedArrayToBst(list, start, mid - 1);
		root.right = sortedArrayToBst(list, mid + 1, end);
		return root;

	}

	/*
	 * 
	 * This function prints the output of merging two bst's into one large Bst.
	 */
	public void printList(TreeNode root) {
		if (root == null) {
			return;
		}

		printList(root.left);
		System.out.println(root.data + " ");
		printList(root.right);
	}

	/*
	 * This is the actual function which takes two bst's as input and merges
	 * into one large bst by making use of the above functions which implements
	 * the desired logic!.
	 */

	public TreeNode getTwoBst(TreeNode firstTree, TreeNode secondTree) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> mergeResults = new ArrayList<Integer>();

		list1 = inOrderTraversal(firstTree, list1);
		list2 = inOrderTraversal(secondTree, list2);
		mergeResults = mergeTwoArrays(list1, list2);
		TreeNode mergeBst = convertSortedListToTree(mergeResults);
		return mergeBst;

	}

	public static void main(String[] args) {
		MergeTwoBalancedBst object = new MergeTwoBalancedBst();
		TreeNode firstTree = new TreeNode(5);
		firstTree.left = new TreeNode(1);
		firstTree.right = new TreeNode(15);
		firstTree.right.left = new TreeNode(14);

		TreeNode secondTree = new TreeNode(25);
		secondTree.left = new TreeNode(12);
		secondTree.right = new TreeNode(50);

		TreeNode res = object.getTwoBst(firstTree, secondTree);
		object.printList(res);

	}
}
