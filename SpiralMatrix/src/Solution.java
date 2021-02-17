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

    // Recursive Solution:
    // Like an onion, start from the outer layer, iterate top, right, bottom, and left edges, then go to inner layer. At the inner layer, the row and col decrease by 2
    // Base Case: when row and col are both 1, it's the last element. When either of them reaches 0, it's done

        public List<Integer> spiralOrderRecursion(int[][] matrix) {
            List<Integer> res = new ArrayList();
            traverse(matrix, matrix.length, matrix[0].length, res, 0);
            return res;
        }

        public void traverse(int [][] m, int r, int c, List<Integer> res, int layer) {
            if(r == 0 || c == 0) {
                return ;
            }
            else if(r == 1 && c == 1) {
                res.add(m[layer][layer]);
                return ;
            }
            else if(r == 1) {
                for(int i = 0; i < c; i++) {
                    res.add(m[layer][layer+i]);
                }
                return ;
            }
            else if(c == 1) {
                for(int i = 0; i < r; i++) {
                    res.add(m[layer+i][layer]);
                }
                return ;
            }

            // Top Edge: left to right
            for(int i = 0; i < c - 1; i++) {
                res.add(m[layer][layer+i]);
            }

            // Right Edge: top to bottom
            for(int i = 0; i < r - 1; i++) {
                res.add(m[layer+i][c-1+layer]);
            }

            // Bottom Edge: right to left
            for(int i = c - 1; i > 0; i--) {
                res.add(m[r-1+layer][layer+i]);
            }

            // Left Edge: bottom to top
            for(int i = r - 1; i > 0; i--) {
                res.add(m[layer+i][layer]);
            }

            traverse(m, r - 2, c - 2, res, layer + 1);
        }
}
