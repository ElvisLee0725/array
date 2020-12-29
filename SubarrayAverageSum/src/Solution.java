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
    // Get curSum within this range
    // Check if the average of that range is greater than the average of totalSum - curSum?
    // If so, add the start and end index into the result
    // After the iteration, convert the ArrayList back to array and return
    // Time: O(n^3), Space: O(1)
    public Subarray [] subarrayAverageSum(int [] arr) {
        int totalSum = 0;
        for(int n : arr) {
            totalSum += n;
        }

        List<Subarray> res = new ArrayList();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                int curSum = 0;
                for(int k = i; k <= j; k++) {
                    curSum += arr[k];
                }
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
