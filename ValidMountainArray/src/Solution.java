// Edge Case:
// 1. If the arr's length is less than 3, return false
// 2. If the cur index is 1 and peak is found, return false (Descending array)
// 3. If until the end foundPeak is still false, return false (Ascending array)
// For a valid mountain array, it has a peak arr[peak]. Every number before arr[peak] is in ascending order, while every number after it is in descending order.
// Use a variable foundPeak = false as initial value
// Iterate the input array from index 1, when foundPeak is false, check if value at cur index is greater than value at index-1? If they are equal, return false. If value at cur index is smaller, set foundPeak to true!
// Once we found peak, then value at cur index should be smaller than value at index-1. So, if arr[i] >= arr[i-1], return false
// After the iteration, if foundPeak is still false, then we don't have a mountain. Return foundPeak

// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{3, 4, 3, 2, 1};
        System.out.print(new Solution().validMountainArray(arr));
    }
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }
        boolean foundPeak = false;
        for(int i = 1; i < arr.length; i++) {
            if(!foundPeak) {
                if(arr[i] == arr[i-1]) {
                    return false;
                }
                else if(arr[i] < arr[i-1]) {
                    if(i == 1) {
                        return false;
                    }
                    foundPeak = true;
                }
            }
            else {
                if(arr[i] >= arr[i-1]) {
                    return false;
                }
            }
        }
        return foundPeak;
    }
}
