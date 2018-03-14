import java.util.*;

class Node {
	int key;
	int val;
	Node prev;
	Node next;
	
	public Node(int key, int val) {
		this.key = key;
		this.val = val;
		this.prev = this.next = null;
	}
}
public class LRUCache {
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	Node head =  new Node(-1, -1);
	Node tail = new Node(-1, -1);
	/*
	 * check if it exists in map, if yes, replace it and make it head 
	 * because it was recently used
	 */
	public void put(int key, int val) {
		Node n = map.get(key);
		if(n == null) {
			n = new Node(key, val);
			map.put(key, n);
			if(map.size() == 0) {
				head = tail = n;
			} else {
				head.prev = n;
				n.next = head;
				head = n;
			}
		} else {
			n.prev.next = n.next;
			n.next.prev = n.prev;
			n.val = val;
			head.prev = n;
			n.next = head;
			head = n;
		}
	}
	/*
	 * if it exists in map, update it to head since it is most recently used
	 */
	public int get(int key) {
		Node n = map.get(key);
		if(n==null)
			return -1;
		else {
			int val = n.val;
			n.prev.next = n.next;
			n.next.prev = n.prev;
			head.prev = n;
			n.next = head;
			head = n;
			return val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache();
		Node n = new Node(3, 5);
		cache.put(2,  4);
		System.out.println(cache.get(2));
	}

}
