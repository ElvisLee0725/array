// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{2, 7, 11, 15};
        int [] res = new Solution().twoSum(arr, 9);
        for(Integer n : res) {
            System.out.print(n + " ");
        }
    }
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
}
