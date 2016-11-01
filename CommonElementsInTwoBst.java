package NewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommonElementsInTwoBst {

	static class TreeNode {
		TreeNode left, right;
		int data;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	
	
	public static List<Integer> getResult(TreeNode firstNode,TreeNode secondNode){
		List<Integer> resultArray = new ArrayList<Integer>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		while(true){
			if(firstNode!=null){
				s1.push(firstNode);
				firstNode=firstNode.left;
			}else if(secondNode!=null){
				s2.push(secondNode);
				secondNode=secondNode.left;
			}else if(!s1.isEmpty() && !s2.isEmpty()){
				firstNode = s1.peek();
				secondNode = s2.peek();
				
				
				if(firstNode.data==secondNode.data){
					resultArray.add(firstNode.data);
					s1.pop();
					s2.pop();
					
					firstNode = firstNode.right;
					secondNode = secondNode.right;
				}else if(firstNode.data<secondNode.data){
					s1.pop();
					firstNode=firstNode.right;
					secondNode=null;
				}else if(firstNode.data>secondNode.data){
					s2.pop();
					secondNode=secondNode.right;
					firstNode=null;
				}
			}else{
				break;
			}
		}
		return resultArray;
		}
	

	public static void main(String[] args) {
		
		TreeNode rootFirstTree = new TreeNode(15);
		rootFirstTree.left = new TreeNode(12);
		rootFirstTree.right = new TreeNode(25);
		rootFirstTree.left.left = new TreeNode(9);
		
		

		System.out.println();

		TreeNode rootSecondTree = new TreeNode(25);
		rootSecondTree.left = new TreeNode(20);
		rootSecondTree.right = new TreeNode(50);
		rootSecondTree.left.left = new TreeNode(15);
		
	    System.out.println(getResult(rootFirstTree, rootSecondTree));
		

	}
}
