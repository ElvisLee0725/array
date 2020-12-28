// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
// Return the array in the form [x1,y1,x2,y2,...,xn,yn].
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{2, 5, 1, 3, 4, 7};
        int [] res = new Solution().shuffle(arr, 3);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
    // Method 1:
    // Set i = 1, j = nums.length - 2;
    // While j is greater than i, reverse from index i to index j
    // Then, reverse from index i to n - 1, index n to j
    // Return the input array after the while loop
    // Time: O(n^2), Space: O(1)

    // Method 2:
    // Create another array with the same length
    // Use index i pointing at 0, index j pointing at n;
    // Keep assigning nums[i] and nums[j] to the new array until i reaches n
    // Return the new array at the end
    // Time: O(n), Space: O(n)

        public int[] shuffle(int[] nums, int n) {
            // int i = 1;
            // int j = nums.length - 2;
            // while(i < j) {
            //     reverse(nums, i, j);
            //     reverse(nums, i, n-1);
            //     reverse(nums, n, j);
            //     i++;
            //     j--;
            // }
            // return nums;
            int [] res = new int[nums.length];
            int i = 0;
            int j = n;
            int index = 0;
            while(i < n) {
                res[index++] = nums[i++];
                res[index++] = nums[j++];
            }
            return res;
        }

        public void reverse(int [] arr, int i, int j) {
            while(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
}
