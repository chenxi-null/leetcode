package com.leetcode.other;

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/15
 */
public class Hanoi {

    public void printMoveStep(int n) {
        move(n, 'A', 'B', 'C');
    }

    public void move(int n, char from, char buffer, char to) {
        if (n == 0) {
            return;
        }
        move(n - 1, from, to, buffer);
        System.out.printf("moving %d from %s to %s\n", n, from, to);
        move(n - 1, buffer, from, to);
    }

    public int count(int n) {
        if (n == 1) {
            return 1;
        }
        // move n-1 o from A -> B   n-1
        // move the n-th from A -> C  1
        // move n-1 o from B -> C   n-1
        return 2 * count(n - 1) + 1;
    }
}
