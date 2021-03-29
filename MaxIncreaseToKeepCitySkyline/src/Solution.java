// When increasing the height of a building, need to consider from top bottom and left right view
// The min of view TB and LR is the max height I can increase for that building
// 1. Get the TB skyline and store as a 1D array, also get the LR skyline by iterating each row / column of the input matrix
// 2. Iterate the inpu grid and sum up the min of LR[i] and TB[j] minus grid[i][j]
// Time: O(mn), Space: O(m+n)
class Solution {
    public static void main(String[] args) {
        int [][] grid = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.print(new Solution().maxIncreaseKeepingSkyline(grid));
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [] TB = new int[col];
        int [] LR = new int[row];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                TB[j] = Math.max(TB[j], grid[i][j]);
                LR[i] = Math.max(LR[i], grid[i][j]);
            }
        }

        int sum = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                sum += Math.min(LR[i], TB[j]) - grid[i][j];
            }
        }
        return sum;
    }
}
