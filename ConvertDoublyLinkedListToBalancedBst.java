package NewQuestions;

public class ConvertDoublyLinkedListToBalancedBst {

	static ListNode head = null;
	static ListNode tail = null;

	static class ListNode {
		ListNode prev, next;
		int data;

		public ListNode(int data) {
			this.data = data;
		}
	}

	static class TreeNode {
		TreeNode left, right;
		int data;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	/*
	 * Calculates the length of DOUBLY LINKED LIST
	 * 
	 * */
	public static int getListLength() {
		int length = 0;
		ListNode current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	
	
	public void sortedDllToList(){
	int lengthofList = getListLength();
	head = sortedLinkedListToBalancedBST(lengthofList);
	tail = null;
	}
	
	public static ListNode sortedLinkedListToBalancedBST(int length){
		if(length==0){
			return null;
		}
		
		ListNode leftPart = sortedLinkedListToBalancedBST(length/2);
		ListNode root = head;
		root.prev = leftPart;
		head=head.next;
		ListNode rightPart = sortedLinkedListToBalancedBST(length-(length/2)-1);
		root.next = rightPart;
		return root;
		
	}
	
	
	public void addToDoublyLinkedList(int data){
		ListNode newNode = new ListNode(data);
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void InorderTraversal(ListNode root){
		if(root==null){
			return;
		}
		
		InorderTraversal(root.prev);
		System.out.println(root.data + " ");
		InorderTraversal(root.next);
		
	}
	
	
	
	
	public static void main(String[] args) {
    ConvertDoublyLinkedListToBalancedBst object = new ConvertDoublyLinkedListToBalancedBst();
    for(int i=1;i<6;i++){
    	object.addToDoublyLinkedList(i);
    }
    object.sortedDllToList();
    object.InorderTraversal(head);
    
	}

}
