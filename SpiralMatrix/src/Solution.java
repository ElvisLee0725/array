// Given an m x n matrix, return all elements of the matrix in spiral order.

// Iterative Solution:
// Use a layer starts from 0, when 1 layer is finished, layer increases
// When layer is smaller than the half of min of row and col, do:
// Iterate top, right, bottom and left edge
// After the for loop, if row - layer * 2 == 1, there are cols need to be filled
// Else if col - layer * 2 == 1, there are rows to be filled
// If both are 1, there is 1 last item

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int [][] m = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = new Solution().spiralOrder(m);
        System.out.print(res);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList();
        int layer;
        for(layer = 0; layer < Math.min(row, col) / 2; layer++) {
            int r = row - layer * 2, c = col - layer * 2;
            int ri = layer, ci = layer;
            // Top: left to right
            for(int i = 0; i < c - 1; i++) {
                res.add(matrix[ri][ci++]);
            }

            // Right: top to bottom
            for(int i = 0; i < r - 1; i++) {
                res.add(matrix[ri++][ci]);
            }

            // Bottom: right to left
            for(int i = 0; i < c - 1; i++) {
                res.add(matrix[ri][ci--]);
            }

            // Left: bottom to top
            for(int i = 0; i < r - 1; i++) {
                res.add(matrix[ri--][ci]);
            }
        }
        int rowLeft = row - layer * 2;
        int colLeft = col - layer * 2;

        if(rowLeft == 1 && colLeft == 1) {
            res.add(matrix[layer][layer]);
        }
        else if(rowLeft == 1) {
            for(int i = 0; i < colLeft; i++) {
                res.add(matrix[layer][layer+i]);
            }
        }
        else if(colLeft == 1) {
            for(int i = 0; i < rowLeft; i++) {
                res.add(matrix[layer+i][layer]);
            }
        }
        return res;
    }
}
