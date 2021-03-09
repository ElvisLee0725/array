// Determine if there exists a set of four elements in a given array that sum to the given target number.
// Assumptions: The given array is not null and has length of at least 4

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[] {1, 2, 2, 3, 4};
        System.out.print(new Solution().fourSum(arr, 9));
    }

    // Create 2 nested for loops with indice i and j. i is the start index and j is the end index
    // Create a hashmap to store <previous sums of index i and j, index of j>
    // Get the sum of arr[i] and arr[j] first, and check if the HashMap contains a key equals to t - sum
    // , and its value is less than the index i to make sure the solution is legit
    // If curSum wasn't in the map, add it and index j into the hashmap before going to the next index
    // Time: O(n^2), Space: O(n^2)

    public boolean fourSum(int [] arr, int t) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int j = 1; j < arr.length; j++) {
            for(int i = 0; i < j; i++) {
                int curSum = arr[i] + arr[j];
                if(map.containsKey(t - curSum) && map.get(t - curSum) < i) {
                    return true;
                }

                if(!map.containsKey(curSum)) {
                    map.put(curSum, j);
                }
            }
        }
        return false;
    }

    public List<List<Integer>> fourSumReturnUniqueResults(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        // Edge Case: input array length less than 4, return empty List
        if(nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet();

        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length-2; j++) {
                int left = j + 1;
                int right = nums.length-1;
                int curTarget = target - (nums[i] + nums[j]);
                while(left < right) {
                    if(nums[left] + nums[right] == curTarget) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        hs.add(list);
                        left = moveLeft(nums, left);
                        right = moveRight(nums, right);
                    }
                    else if(nums[left] + nums[right] > curTarget) {
                        right = moveRight(nums, right);
                    }
                    else {
                        left = moveLeft(nums, left);
                    }
                }
            }
        }
        for(List<Integer> list : hs) {
            res.add(list);
        }
        return res;
    }

    private int moveLeft(int [] arr, int left) {
        while(left < arr.length-2 && arr[left] == arr[left+1]) {
            left++;
        }
        return left + 1;
    }

    private int moveRight(int [] arr, int right) {
        while(right > 2 && arr[right] == arr[right-1]) {
            right--;
        }
        return right - 1;
    }
}