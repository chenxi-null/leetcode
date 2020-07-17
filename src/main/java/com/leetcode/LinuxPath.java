package com.leetcode;

import java.util.ArrayDeque;

/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

https://leetcode-cn.com/problems/simplify-path
 */
class LinuxPath {

    public String simplifyPath(String path) {
        ArrayDeque<StringBuilder> deque = new ArrayDeque<>();
        StringBuilder currWord = new StringBuilder();

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (isLetter(c)) {
                currWord.append(c);
            } else if (isSlash(c)) {
                trigger(deque, currWord);
                //reset currWord
                currWord = new StringBuilder();
            }
        }
        trigger(deque, currWord);

        // convert stack to path
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : deque) {
            result.append("/").append(sb);
        }
        return result.toString();
    }

    private void trigger(ArrayDeque<StringBuilder> deque, StringBuilder currWord) {
        if ("..".equals(currWord.toString())) {
            //stack.remove if stack is not empty
            deque.pollLast();
        } else if (currWord.length() > 0 && !".".equals(currWord.toString())) {
            //stack.put(currWord) if exist currWord
            deque.addLast(currWord);
        }
    }

    private boolean isSlash(char c) {
        return c == '/';
    }

    private boolean isLetter(char c) {
        return !isSlash(c);
    }
}