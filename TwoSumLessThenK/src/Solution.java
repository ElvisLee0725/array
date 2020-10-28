// Two Pointers
// Sort the input array
// Use index i and j starts from the begining and end of array. If A[i] + A[j] >= K, j--
// Else, update the result and i++;
// Keep moving i and j until i >= j

import java.util.Arrays;

// Time: O(nlogn), Space: O(logn) for sorting
class Solution {
    public static void main(String[] args) {
        int [] A = new int[]{34,23,1,24,75,33,54,8};
        System.out.print(new Solution().twoSumLessThanK(A, 60));
    }
    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        Arrays.sort(A);
        int i = 0;
        int j = A.length-1;
        while(i < j) {
            if(A[i] + A[j] >= K) {
                j--;
            }
            else {
                res = Math.max(res, A[i] + A[j]);
                i++;
            }
        }
        return res;
    }
}
