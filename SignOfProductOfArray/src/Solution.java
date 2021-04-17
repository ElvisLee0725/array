// There is a function signFunc(x) that returns:
//
//1 if x is positive.
//-1 if x is negative.
//0 if x is equal to 0.
//You are given an integer array nums. Let product be the product of all values in the array nums.
//
//Return signFunc(product).

// Product: Consider integer overflow
// Iterate input array, if cur number is 0, return 0. If current number is negative then * -1
// Return the final number
class Solution {
    public static void main(String[] args) {
        int [] nums = new int[]{7,36,96,70,85,23,5,18,4,12,89,92,9,30,53,14,96,32,13,43,37,60,75,7,83,68,20,8,-24,-80,-27,-92,-96,-20,-16,-52,-49,-38};
        System.out.print(new Solution().arraySign(nums));
    }
    public int arraySign(int[] nums) {
        int product = 1;
        for(int n : nums) {
            if(n == 0) {
                return 0;
            }
            else if(n < 0) {
                product *= -1;
            }

        }
        return product;
    }
}
