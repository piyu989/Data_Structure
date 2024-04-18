package ThisWeek;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/

public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class MyQueue {
    Stack<Integer>st;
    Stack<Integer>demo=new Stack<>();
    public MyQueue() {
        this.st=new Stack();
    }
    
    public void push(int x) {
        st.add(x);
    }
    
    public int pop() {
        while(!st.isEmpty()){
            demo.add(st.pop());
        }
        int ans=demo.pop();
        while(!demo.isEmpty()){
            st.add(demo.pop());
        }
        return ans;
    }
    
    public int peek() {
        if(st.isEmpty()){
            return 0;
        }
        while(!st.isEmpty()){
            demo.add(st.pop());
        }
        int ans=demo.peek();
        while(!demo.isEmpty()){
            st.add(demo.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return st.isEmpty()&&demo.isEmpty();
    }
}

