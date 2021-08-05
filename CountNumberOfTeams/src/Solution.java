/*
All rating in array is unique
Brute Force:
- Use 3 for nested for loop to get 3 indices and compare if that matches a valid team?
- Getting all possible combinations and check if that combination is valid
- Time: O(N^3), Space: O(1)

Sol 2:
  [2,5,3,4,1]
       i
   lL = 1
   lS = 1
   rL = 1
   rS = 1
  // Iterating the array, at each index, check the left side and right side to find the number of left Larger, left Smaller, right Larger, right Smaller
  // count += lL * rS + lS * rL
  Time: O(N^2), Space: O(1)
*/

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numTeams(new int[]{2,5,3,4,1}));
    }
    public int numTeams(int[] rating) {
        int count = 0;
        for(int i = 1; i < rating.length-1; i++) {
            int leftSmaller = 0;
            int leftLarger = 0;
            for(int j = 0; j < i; j++) {
                if(rating[i] > rating[j]) {
                    leftSmaller++;
                }
                else {
                    leftLarger++;
                }
            }

            int rightSmaller = 0;
            int rightLarger = 0;
            for(int j = i + 1; j < rating.length; j++) {
                if(rating[i] > rating[j]) {
                    rightSmaller++;
                }
                else {
                    rightLarger++;
                }
            }

            count += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }
        return count;
    }
}
