// Use an array of length 101 to store the freq for each number
// Ex. [0, 1, 2, 1, ..., 1]
// Iterate the frequecy array and use a counter to get the sum of freq before each number
// 1. save arr[i] to tmp
// 2. arr[i] = count;
// 3. count += tmp
//.     0. 1. 2. 3. 4. 5. 6. 7. 8 ...
// Ex. [0, 0, 1, 3, 4, 4, 4, 4, 4, 5...]
// Finally, iterate the nums array and get the # of smaller number for each num[i] and store in result
// Time: O(N), Space: O(1)
class Solution {
    public static void main(String[] args) {
        int [] res = new Solution().smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] arr = new int[101];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        int count = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            arr[i] = count;
            count += tmp;
        }
        // 0 is the min number, so no number will it be bigger than
        arr[0] = 0;

        int [] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = arr[nums[i]];
        }
        return res;
    }
}