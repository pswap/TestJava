// https://leetcode.com/problems/add-two-numbers/description/
class Node {
	int val;
	Node next;
	Node(int val) {
		this.val = val;
		this.next = null;
	}
}

public class AddTwoNumbers {
	
	public static void addNumbers(Node l1, Node l2) {
		Node p1 = l1; 
		Node p2 = l2;
		Node p3 = new Node(0);
		int carry = 0;
		while(p1 != null || p2 != null) {
			int x = p1 == null ? 0 : p1.val;
			int y = p2==null ? 0 : p2.val;
			int temp = x + y + carry;
			carry = temp/10;
			int newval = temp%10;
			
			p3.next = new Node(newval);
			p3 = p3.next;
			if(p1!= null)
				p1 = p1.next;
			if(p2!=null)
				p2 = p2.next;
		}
		if(carry >0)
			p3.next = new Node(carry);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
