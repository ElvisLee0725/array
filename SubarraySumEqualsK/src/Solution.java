// Use HashMap<Prev Sum, Frequency> and initalize with <0, 1> since before it starts the sume is 0 with frequency 1
// Therefore, if curSum - k equals prevSum, that means k is the subarray sum of curSum - prevSum
// Iterate from index 0 to last index, calculate the curSum first. If map contains curSum - k, count add by its frequency
// Update the map with <curSum, 1> or increase value by 1 if curSum is already in map
// Time: O(n), Space: O(n)

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 2, 3};
        System.out.print(new Solution().subarraySum(arr, 3));
    }
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int curSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if(map.containsKey(curSum - k)) {
                count += map.get(curSum - k);
            }
            map.putIfAbsent(curSum, 0);
            map.put(curSum, map.get(curSum) + 1);
        }
        return count;
    }
}