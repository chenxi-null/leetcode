package com.leetcode.weekly.weekly241.second;

class Solution {
    public int minSwaps(String s) {
        int ans = 0;
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') cnt0++;
            else cnt1++;
        }
        if (Math.abs(cnt0 - cnt1) > 1) return -1;

        int numNeedSwap = 0;
        char curExpectedState;
        if (cnt0 > cnt1) {
            curExpectedState = '0';
            int swapCnt = find(s, curExpectedState);
            return swapCnt / 2;
        } else if (cnt1 > cnt0) {
            curExpectedState = '1';
            int swapCnt = find(s, curExpectedState);
            return swapCnt / 2;
        } else {
            int swapCnt1 = find(s, '0');
            int swapCnt2 = find(s, '1');
            return Math.min(swapCnt1, swapCnt2) / 2;
        }
    }

    int find(String s, char state) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != state) {
                ans++;
            }
            state = reverse(state);
        }
        return ans;
    }

    char reverse(char state) {
        return (state == '1') ? '0' : '1';
    }
}
/*
0 1 1 0 0
1 0 1 0 1

111000
101010

---
11 0101 00
111 0101 000
1111 0101 0000

... 1111 ... 0000 ...
... 0101 ... 0101 ...

11111  00000

continous-len: 2, 3, 4, 5
      swapcnt: 1, 1, 2, 2

---

not equal:

10 111 01 00 1010

 0 111 01 00 1010

...0 111 0101 00 1...
swap once:
1..10 101 0101 10 10..10

...0 1111 0101 000 1...

 */