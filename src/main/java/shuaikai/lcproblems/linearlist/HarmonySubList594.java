package shuaikai.lcproblems.linearlist;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ret = 0;
        for (int x : map.keySet()) {
            if (map.containsKey(x + 1)) {
                ret = Math.max(ret, map.get(x) + map.get(x + 1));
            }
        }
        return ret;
    }
}

/**
 * <a href="https://leetcode.cn/problems/longest-harmonious-subsequence/description/">594 最长和谐子序列</a>
 *
 * @author wddjwk
 */
public class HarmonySubList594 {
    public static void main(String[] args) {
        Solution su = new Solution();
        int[] testCase = {1, 1, 1, 1, 1};
        System.out.println(su.findLHS(testCase));
    }
}
