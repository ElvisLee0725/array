// Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
//
// There may be duplicates in the original array.
//
// Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

// Count how many times the nums array rotates?
// If count is 0, return true
// If count is 1, check if the nums[0] >= nums[nums.length-1]
// If count is greater than 1, return false
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{2,1,3,4};
        System.out.print(new Solution().check(arr));
    }
    public boolean check(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                count++;
            }

            if(count > 1) {
                return false;
            }
        }
        if(count == 0) {
            return true;
        }
        return nums[0] >= nums[nums.length-1];
    }
}
