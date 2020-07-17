package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] ans = new String[n];
        Map<String, Integer> map = new HashMap<>(); // name -> idx
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                map.put(name, 0);
                ans[i] = name;
            } else {
                int idx = map.get(name);
                String nn;
                do {
                    nn = name + '(' + (++idx) + ')';
                } while (map.containsKey(nn));
                map.put(name, idx);
                map.put(nn, 0);
                ans[i] = nn;
            }
        }
        return ans;
    }
}