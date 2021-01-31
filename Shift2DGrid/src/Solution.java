import java.util.ArrayList;
import java.util.List;

// Edge Case: If k % m*n is 0, just return the original grid
// To shift:
// Record current value grid[i][j], replace it by prev, and then assign prev to cur
// Prev starts from the last value grid[grid.length-1][grid[0].length-1];
// Time: O(n^2), Space: O(n^2)
class Solution {
    public static void main(String[] args) {
        int [][] grid = new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        List<List<Integer>> res = new Solution().shiftGrid(grid, 4);
        for(List<Integer> list : res) {
            for(int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        k = k % (m*n);
        int x = 0;;
        while(x < k) {
            int prev = grid[m-1][n-1];
            int cur = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    cur = grid[i][j];
                    grid[i][j] = prev;
                    prev = cur;
                }
            }
            x++;
        }

        // Put the final result to List<List<Integer>>     
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
            res.add(new ArrayList(list));
            list.clear();
        }
        return res;
    }
}