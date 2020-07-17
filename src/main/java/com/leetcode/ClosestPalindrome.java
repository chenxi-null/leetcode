package com.leetcode;

import java.util.Objects;

public class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return plus(n, -1);
        }
        // 1000 -> 999
        if (isPow10(n)) {
            return plus(n, -1);
        }
        // 1001 -> 999
        if (isPow10Plus1(n)) {
            return plus(n, -2);
        }
        // 99 -> 101
        if (isAll9(n)) {
            return plus(n, 2);
        }
        else {
            if (n.length() % 2 == 0) {
                return closest(n, buildEven(n, -1), buildEven(n, 0), buildEven(n, 1));
            } else {
                return closest(n, buildOdd(n, -1), buildOdd(n, 0), buildOdd(n, 1));
            }
        }
    }

    // a < b < c
    private String closest(String n, String a, String b, String c) {
        long d1 = absDiff(n, a);
        long d2 = absDiff(n, b);
        long d3 = absDiff(n, c);
        long minDiff = Math.min(d1, Math.min(d2, d3));
        return (d1 == minDiff)
                ? a
                : (d2 == minDiff)
                ? b : c;
    }

    private long absDiff(String x, String y) {
        long abs = Math.abs(Long.parseLong(x) - Long.parseLong(y));
        if (abs == 0) return Long.MAX_VALUE;
        return abs;
    }

    private String buildOdd(String n, int d) {
        String half = n.substring(0, n.length() / 2 + 1);
        if (d != 0) {
            half = plus(half, d);
        }
        return half + reverse(half.substring(0, half.length() - 1));
    }

    private String buildEven(String n, int d) {
        String half = n.substring(0, n.length() / 2);
        if (d != 0) {
            half = plus(half, d);
        }
        return half + reverse(half);
    }

    private String plus(String n, int num) {
        return String.valueOf(Long.parseLong(n) + num);
    }

    private String reverse(String n) {
        return new StringBuilder(n).reverse().toString();
    }

    private boolean isAll9(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isPow10(String n) {
        if (n.charAt(0) != '1') {
            return false;
        }
        for (int i = 1; i < n.length(); i++) {
            if (n.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private boolean isPow10Plus1(String n) {
        if (n.charAt(0) != '1') {
            return false;
        }
        for (int i = 1; i < n.length() - 1; i++) {
            if (n.charAt(i) != '0') {
                return false;
            }
        }
        return n.charAt(n.length() - 1) == '1';
    }

    private boolean isPalindromic(String n) {
        return Objects.equals(n, new StringBuilder(n).reverse().toString());
    }
}