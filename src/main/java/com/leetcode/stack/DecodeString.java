package com.leetcode.stack;
/*
https://leetcode-cn.com/problems/decode-string/

394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

import java.util.Stack;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/9
 */
public class DecodeString {
    /*
    3[a2[c]]4[1[a]2[b]]
    3[ y2[x] ] 4[ 2[z]3[t] ]
    ---

    #[share] sharding solution:
    1. two stacks
    2. recursion
     */
    public String decodeString(String s) {
        // num * word
        return null; //todo
    }


    public String _decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Stack<Object> stack = new Stack<>();
        StringBuilder numBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numBuilder.append(c);
            } else if (c == '[') {
                Integer num = Integer.valueOf(numBuilder.toString());
                stack.push(num);
                numBuilder = new StringBuilder();
            } else if (c == ']') {
                String w = (String) stack.pop();
                Integer num = (Integer) stack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sb.append(w);
                }
                pushString(stack, sb.toString());
            } else {
                pushString(stack, String.valueOf(c));
            }
        }
        return (String) stack.pop();
    }

    private void pushString(Stack stack, String str) {
        if (!stack.isEmpty() && stack.peek() instanceof String) {
            stack.push(stack.pop() + str);
        } else {
            stack.push(str);
        }
    }
}
