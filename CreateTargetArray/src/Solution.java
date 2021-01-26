import java.util.ArrayList;
import java.util.List;
// Given two arrays of integers nums and index. Your task is to create target array under the following rules:
//
//Initially target array is empty.
//From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
//Repeat the previous step until there are no elements to read in nums and index.
//Return the target array.
//
//It is guaranteed that the insertion operations will be valid.

// 1 <= nums.length, index.length <= 100
// nums.length == index.length
// 0 <= nums[i] <= 100
// 0 <= index[i] <= i

// Use a arraylist with capacity initialized. (Not size!!) to reduce memory re-allocation time.
// Since the insertion is always valid, it always starts from index 0, and only insert at places
// with value in it. 
// Iterate the length of array, insert at index[i] with value nums[i]
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{0,1,2,3,4};
        int [] index = new int[]{0,1,2,2,1};
        int [] res = new Solution().createTargetArray(arr, index);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList(nums.length);
        for(int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int [] res = new int[nums.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}