import java.util.HashMap;
import java.util.Map;

// Given an array of integers nums.
// pair (i,j) is called good if nums[i] == nums[j] and i < j.
// Return the number of good pairs.
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4};
        System.out.print(new Solution().numIdenticalPairs(arr));
    }
    // Use a HashMap to store all the <Values, Number of indices that shares the value>
    // Iterate each entry of the map, if the current entry's value is greater than 1, that means that value has more than 1 index and can form
    // pairs. Use combination formula to count the combination and sum up pairs
    // Return the number of pairs
    // Time: O(n), Space: O(n)

        public int numIdenticalPairs(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap();
            for(int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], 0);
                map.put(nums[i], map.get(nums[i]) + 1);
            }

            int count = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() > 1) {
                    count +=  (entry.getValue() * (entry.getValue()-1)) / 2;
                }
            }
            return count;
        }
}
