// Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent
// (up/down/left/right) human beings into zombies every hour.
// Find out how many hours does it take to infect all humans?

import java.util.LinkedList;
import java.util.Queue;

// BFS
// Iterate the matrix and get the position of all zombies into a queue. Use a visited matrix to mark
// all zombie position to true
// Expand from the queue and get all unvisited neighbor positions into queue
// Count plus 1 after each round of expansion
// Keep doing until the queue is empty
// Return count - 1 at the end
// Time: O(mn), Space: O(mn)
public class Solution {
    public static void main(String[] args) {
        int [][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
        int [][] grid2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(new Solution().zombieMatrix(grid2));
    }

    class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int zombieMatrix(int [][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean [][] visited = new boolean[m][n];
        Queue<Pos> q = new LinkedList();
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new Pos(i, j));
                }
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pos cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                // Top
                if(x > 0 && !visited[x-1][y]) {
                    visited[x-1][y] = true;
                    q.offer(new Pos(x-1, y));
                }

                // Bottom
                if(x < m - 1 && !visited[x+1][y]) {
                    visited[x+1][y] = true;
                    q.offer(new Pos(x+1, y));
                }

                // Left
                if(y > 0 && !visited[x][y-1]) {
                    visited[x][y-1] = true;
                    q.offer(new Pos(x, y-1));
                }

                // Right
                if(y < n - 1 && !visited[x][y+1]) {
                    visited[x][y+1] = true;
                    q.offer(new Pos(x, y+1));
                }
            }
            count++;
        }
        return count - 1;
    }
}
