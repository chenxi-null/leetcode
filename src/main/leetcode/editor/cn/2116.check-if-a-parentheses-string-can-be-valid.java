/*
 * @lc app=leetcode.cn id=2116 lang=java
 *
 * [2116] Check if a Parentheses String Can Be Valid
 * #Tag/Greedy
 */

// @lc code=start
class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Integer> lockedLeftIdx = new LinkedList<>();
        Deque<Integer> unlockedIdx = new LinkedList<>();
        Set<Integer> removedIdx = new HashSet<>();
        // match all locked ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isLock = locked.charAt(i) == '1';
            if (!isLock) {
                unlockedIdx.offer(i);
            } else if (c == '(') {
                lockedLeftIdx.offer(i);
            } else {
                if (!lockedLeftIdx.isEmpty()) {
                    removedIdx.add(lockedLeftIdx.pollLast());
                } else if (!unlockedIdx.isEmpty()) {
                    removedIdx.add(unlockedIdx.pollFirst());
                } else {
                    return false;
                }
                removedIdx.add(i);
            }
        }
        System.out.println(removedIdx);
        // only locked '(' and 'unlocked' in the string
        int cntUnlocked = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (removedIdx.contains(i)) {
                continue;
            }
            char c = s.charAt(i);
            boolean isLock = locked.charAt(i) == '1';
            if (!isLock) {
                cntUnlocked++;
            } else {
                if (cntUnlocked <= 0) {
                    return false;
                }
                cntUnlocked--;
            }
        }
        return true;
    }
}
// @lc code=end

