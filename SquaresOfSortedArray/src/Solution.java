/*
- Brute Force
    - Iterate the array and square each number
    - Sort the array
    - Time: O(NlogN)
- 2 pointer:
    - Use a left pointer at 0, right pointer at the end of array
    - Iterating rom last index and compare without negative sign:
        - If the value at right is greater assign its square to current index and move right
        - Else, assign the sqaure of left and move left
    - Time: O(N), Space: O(N)
*/

class Solution {
    public static void main(String[] args) {
        int [] res = new Solution().sortedSquares(new int[] {-7,-3,2,3,11});
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int [] res = new int[nums.length];

        for(int i = nums.length-1; i >= 0; i--) {
            if(Math.abs(nums[right]) > Math.abs(nums[left])) {
                res[i] = nums[right] * nums[right];
                right--;
            }
            else {
                res[i] = nums[left] * nums[left];
                left++;
            }
        }

        return res;
    }
}
