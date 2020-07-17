//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// 


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    Stack<Integer> stk_val = new Stack<>();
    Stack<Integer> stk_min = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        stk_min.push(stk_min.isEmpty() ? x : Math.min(getMin(), x));
        stk_val.push(x);
    }
    
    public void pop() {
        stk_val.pop();
        stk_min.pop();
    }
    
    public int top() {
        return stk_val.peek();
    }
    
    public int getMin() {
        return stk_min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
