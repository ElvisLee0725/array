// Repeat directions: East, South, West and North
// Start from 1 step, 2 steps, 3 steps.... each step use 2 times
// East and South use the same steps, while West and North use the same steps
// Keep moving, each time if the coordinate after moving is within rows and cols range, add to result coordiate and increase index by 1.
// Update dirIndex by 1 after each move. Update step when dirIndex is 0 or 2
// Terminate when index has reached the total number of cells
// Time: O(Max(m, n)^2), Space: O(mn)

class Solution {
    public static void main(String[] args) {
        int [][] res = new Solution().spiralMatrixIII(1, 4, 0, 0);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows * cols;
        int [][] res = new int[total][2];

        res[0][0] = rStart;
        res[0][1] = cStart;
        int index = 1;
        int [][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int step = 0;

        while(index < total) {
            if(dirIndex == 0 || dirIndex == 2) {
                step++;
            }

            for(int i = 0; i < step; i++) {
                rStart += dirs[dirIndex][0];
                cStart += dirs[dirIndex][1];

                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    res[index][0] = rStart;
                    res[index][1] = cStart;
                    index++;
                }
            }

            dirIndex = (dirIndex + 1) % 4;
        }
        return res;
    }
}
