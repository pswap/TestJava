// https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {
	
	public static void addNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1; 
		ListNode p2 = l2;
		ListNode p3 = new ListNode(0);
		int carry = 0;
		while(p1 != null || p2 != null) {
			int x = p1 == null ? 0 : p1.val;
			int y = p2==null ? 0 : p2.val;
			int temp = x + y + carry;
			carry = temp/10;
			int newval = temp%10;
			
			p3.next = new ListNode(newval);
			p3 = p3.next;
			if(p1!= null)
				p1 = p1.next;
			if(p2!=null)
				p2 = p2.next;
		}
		if(carry >0)
			p3.next = new ListNode(carry);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
