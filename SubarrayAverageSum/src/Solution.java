import java.util.ArrayList;
import java.util.List;

// Get the start and end index of a subarray that its average sum is greater than the remaining items' average sum
public class Solution {
    public static void main(String[] args) {
        int [] array = new int[]{3, 4, 2};
        Subarray [] ans = new Solution().subarrayAverageSum(array);
        for(Subarray sa : ans) {
            System.out.println(sa.start + ", " + sa.end);
        }
    }

    // Get the total sum of the input array
    // Use nested for loops to get all combinations of start and end index. start and end can be the same
    // Get curSum within this range -> Use an array that arr[i] is the sum from index 0 to i
    // Ex. [3, 4, 2] -> sums[3, 7, 9]
    // Check if the average of that range is greater than the average of totalSum - curSum?
    // If so, add the start and end index into the result
    // After the iteration, convert the ArrayList back to array and return
    // Time: O(n^2), Space: O(n)
    public Subarray [] subarrayAverageSum(int [] arr) {
        int totalSum = 0;
        int [] sums = new int[arr.length];
        sums[0] = arr[0];
        for(int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            if(i > 0) {
                sums[i] = sums[i-1] + arr[i];
            }
        }

        List<Subarray> res = new ArrayList();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                int curSum = i == 0 ? sums[j] : sums[j] - sums[i-1];

                int range = j - i + 1;
                int remainRange = arr.length - range;
                if(remainRange == 0 || curSum / range > (totalSum - curSum) / remainRange) {
                    res.add(new Subarray(i, j));
                }
            }
        }
        return res.toArray(new Subarray[0]);
    }
}
