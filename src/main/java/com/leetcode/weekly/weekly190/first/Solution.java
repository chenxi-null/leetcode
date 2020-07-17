package com.leetcode.weekly.weekly190.first;

import java.util.Objects;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/24
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPrefixOfWord("i love eating burger", "bur"));
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split("\\s");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= searchWord.length() &&
                    Objects.equals(arr[i].substring(0, searchWord.length()), searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}

