/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

https://leetcode-cn.com/problems/implement-stack-using-queues
 */
package com.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class MyStack {

    private Queue<Integer> workQ = new LinkedBlockingQueue<>();
    private Queue<Integer> bakQ = new LinkedBlockingQueue<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        workQ.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (workQ.size() == 0) {
            return 0;
        }
        int workQSize = workQ.size();
        for (int i = 0; i < workQSize - 1; i++) {
            bakQ.add(workQ.remove());
        }
        Queue<Integer> t = workQ;
        workQ = bakQ;
        bakQ = t;
        return bakQ.remove();
    }

    /** Get the top element. */
    public int top() {
        if (workQ.size() == 0) {
            return 0;
        }
        int workQSize = workQ.size();
        for (int i = 0; i < workQSize - 1; i++) {
            bakQ.add(workQ.remove());
        }
        Integer result = workQ.remove();
        bakQ.add(result);

        Queue<Integer> t = workQ;
        workQ = bakQ;
        bakQ = t;
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return workQ.isEmpty();
    }
}
