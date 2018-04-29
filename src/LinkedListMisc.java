
public class LinkedListMisc {
	
	// reverse list in groups of k
	public static Node reverseGroup(Node head, int k) {
        Node curr = head;
        Node temp = null;
        Node prev = null;
        int count = 0;
        while(curr != null && count < k) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        
        if(temp != null)
            head.next = reverseGroup(temp, k);
        return prev;
    }
	
	/*
	 * zip given linkedlist from both end
	 * #1->2->3->4>5->6 = 1->6->2->5->3->4
ALGORITHM
1. Split the list in the middle (first middle if even)
2. Reverse second half
3. Merge nodes from both list 
	 */
	 static Node reverse(Node head) {
	        Node temp;
	        Node prev = null;
	        Node curr = head;
	        while(curr != null) {
	            temp = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = temp;
	        }
	        return prev;
	    }
	    static Node zip_given_linked_list(Node head) {
	        int len = 0;
	        Node slow = head;
	        Node fast = head.next;
	       while(fast!=null && slow!=null) {
	            slow = slow.next;
	           fast = fast.next;
	        }
	        Node temp = slow.next;
	        slow.next = null;
	        Node p1 = head;
	        // reverse second
	        Node p2 = reverse(temp);
	        Node temp1 = null;
	        Node temp2 = null;
	        while(p1!= null && p2 != null) {
	            temp1 = p1.next;
	            temp2 = p2.next;
	            p1.next = p2;
	            p2.next = temp1;
	            p1 = temp1;
	            p2 = temp2;
	        }
	        return head;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
