// Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{2,1,5,0,3};
        System.out.print(new Solution().increasingTriplet(arr));
    }

    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int min = nums[0];
        int min2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > min2) {
                return true;
            }
            else if(nums[i] < min) {
                min = nums[i];
            }
            else if(nums[i] > min && nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return false;
    }
}
