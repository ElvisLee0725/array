// There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
//
//For each location indices[i], do both of the following:
//
//Increment all the cells on row ri.
//Increment all the cells on column ci.
//Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

// Use array rows and cols, rows[i] represents the times to increment at row i. cols[j] represents the times to increment at col j.
// For each row and col combination, if the sum is odd, increase the counter
// Return counter
// Time: O(m*n), Space: O(m+n)
class Solution {
    public static void main(String[] args) {
        int [][] ind = {{0,1},{1,1}};
        System.out.print(new Solution().oddCells(2,3,ind));
    }
    public int oddCells(int m, int n, int[][] indices) {
        int [] rows = new int[m];
        int [] cols = new int[n];
        for(int [] idx : indices) {
            rows[idx[0]]++;
            cols[idx[1]]++;
        }

        int counter = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((rows[i] + cols[j]) % 2 == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }
}