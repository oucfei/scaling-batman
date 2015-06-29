package questions;

import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueue {
	class MyStack1 {
	    //leetcode 184ms, not so efficient.
		//push: O(1), pop:O(n), top:O(n);
	    private Queue<Integer> queue = new LinkedList<Integer>();
	    
	    // Push element x onto stack.
	    public void push(int x) {
	        queue.offer(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        for(int i=0; i<queue.size()-1; i++){
	            queue.offer(queue.poll());
	        }
	        queue.poll();
	    }

	    // Get the top element.
	    public int top() {
	        for(int i=0; i<queue.size()-1; i++){
	            queue.offer(queue.poll());
	        }
	        int top = queue.peek();
	        
	        queue.offer(queue.poll());
	        
	        return top;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}

	class MyStack2 {
	    
	    private Queue<Integer> queue = new LinkedList<Integer>();
	    
	    // Push element x onto stack.
	    public void push(int x) {
	        queue.offer(x);
	        for(int i=0; i<queue.size() -1;i++){
	            queue.offer(queue.poll());
	        }
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        queue.poll();
	    }

	    // Get the top element.
	    public int top() {
	        return queue.peek();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
}
