```java
/*
1, 1
0, 1
1, 0
0, 0
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (null == nums) {
            return 0;
        }

        int[] a = nums;
        int ans = 0;
        int len = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                if (i == 0 || a[i - 1] != 1) {
                    len = 0;
                }
                len++;
                ans = Math.max(ans, len);
            }
        } 
        return ans;
    }
}
```