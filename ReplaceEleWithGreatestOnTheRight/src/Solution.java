// Given an array arr, replace every element in that array with the greatest element among the elements
// to its right, and replace the last element with -1.
// After doing so, return the array.

// Initialize max with -1
// Iterate from last index to index 0:
// Update the cur value with max
// Update max with cur value and max
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        int [] arr = new int[] {17,18,5,4,6,1};
        int [] res = new Solution().replaceElements(arr);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i = arr.length-1; i >= 0; i--) {
            int cur = arr[i];
            arr[i] = max;
            max = Math.max(cur, max);
        }
        return arr;
    }
}
