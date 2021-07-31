/*
Goal: Find the longest mountain subarray length
Edge Case: If arr length is less than 3, return 0

For each arr[i] that is greater than arr[i-1] and greater than arr[i+1], Find the length of height reduce for the left and right side. Update the global max
Ex [2,1,4,7,3,2,5]
Time: O(N), Space: O(1)

*/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestMountain(new int[]{2,1,4,7,3,2,5}));
    }
    public int longestMountain(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        int max = 0;
        for(int i = 1; i < arr.length-1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int j = i - 1;
                while(j > 0 && arr[j] > arr[j-1]) {
                    j--;
                }

                int k = i + 1;
                while(k < arr.length-1 && arr[k] > arr[k+1]) {
                    k++;
                }
                int curLen = (i - j + 1) + (k - i + 1) - 1;
                max = Math.max(max, curLen);
            }
        }
        return max;
    }
}
