// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{2, 7, 11, 15};
        int [] res = new Solution().twoSumSort(arr, 9);
        for(Integer n : res) {
            System.out.print(n + " ");
        }
    }

    // Time: O(n), Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // Time: O(n^2), Space: O(1)
    public int [] twoSumBruteForce(int [] nums, int target) {
        int [] res = new int[2];
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    // Can only return the 2 numbers instead of 2 indice
    // Time: O(nlogn), Space: O(n) for sorting
    public int [] twoSumSort(int [] nums, int target) {
        int [] res = new int[2];
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while(i < j) {
            if(nums[i] + nums[j] == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
            else if(nums[i] + nums[j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return res;
    }
}
