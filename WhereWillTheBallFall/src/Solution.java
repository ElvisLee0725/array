// You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
// Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.

// A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
// A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
// We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.

// Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.

public class Solution {
    public static void main(String[] args) {
        int [][] grid = new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        int [] ans = new Solution().findBall(grid);
        for(int n : ans) {
            System.out.print(n + " ");
        }
    }
    // Iterate each start of ball from 0 to n - 1, assign the cur index to a variable called ball
// While the ball haven't dropped to row m, do:
// If the ball has dropped into a fail position, set res[ball] = -1 and break the while loop.
// Fail Positions:
// If ball at col 0 and val is -1, return -1
// If ball at col n - 1 and val is 1, return -1
// If ball at val 1 and its right cell is -1, return -1
// If ball at val -1 and its left cell is 1, return -1
// Each ball starts from grid[0, ball], if it's a 1, ball moves to grid[i + 1][j + 1]
// Else if it's a -1, ball moves to grid[i + 1][j - 1]
// After the while loop, res[ball] = last position of j
// Time: O(nm), Space: O(1)

        public int[] findBall(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int [] res = new int[n];

            for(int ball = 0; ball < n; ball++) {
                int j = ball;
                int i = 0;
                while(i != m) {
                    int curVal = grid[i][j];
                    if(curVal == 1) {
                        if(j == n-1 || grid[i][j+1] == -1) {
                            res[ball] = -1;
                            break;
                        }
                        j++;
                    }
                    else if(curVal == -1) {
                        if(j == 0 || grid[i][j-1] == 1) {
                            res[ball] = -1;
                            break;
                        }
                        j--;
                    }
                    i++;
                }
                if(i == m) {
                    res[ball] = j;
                }
            }
            return res;
        }
}
