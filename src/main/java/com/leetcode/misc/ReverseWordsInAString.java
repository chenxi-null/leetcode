package com.leetcode.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ReverseWordsInAString {

    public String reverseWords(String s) {
        String trim = s.trim();
        String[] a = trim.split("\\s+");
        List<String> list = Arrays.asList(a);
        Collections.reverse(list);
        return String.join(" ", list);
    }
}