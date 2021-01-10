// Determine if there exists a set of four elements in a given array that sum to the given target number.
// Assumptions: The given array is not null and has length of at least 4

import java.util.HashMap;

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
}
