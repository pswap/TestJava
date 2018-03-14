import java.util.Stack;

public class MinStack {
	static Stack<Integer> stk = new Stack<Integer>();
	static Stack<Integer> minStk = new Stack<Integer>();
	
	public static void push(int val) {
		//if(!stk.empty()) {
		//	System.out.println("stack is full");
		//	return;
		//}
		stk.push(val);
		if(minStk.empty())
			minStk.push(val);
		else if(val <= minStk.peek()) {
			minStk.push(val);
		}
	}
	
	public static int pop() {
		if(stk.isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		}
		int val = stk.pop();
		if(val == minStk.peek())
			minStk.pop();
		return val;
	}
	public static int getMin() {
		return minStk.peek();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		ms.push(9);
		ms.push(5);
		ms.push(2);
		ms.push(3);
		ms.push(6);
		System.out.println("min=" + ms.getMin());
		ms.pop();
		ms.pop();
		ms.pop();
		System.out.println("min=" + ms.getMin());


	}

}
