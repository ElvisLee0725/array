// You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
//
//You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
//
//For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
//
//Return an array answer, where answer[j] is the answer to the jth query.

// For each queries, iterate each point and check from it to center is smaller or equal to radius? If so, count plus 1
// Time: O(mn), Space: O(m). n is number of pointer, m is number of queries

class Solution {
    public static void main(String[] args) {
        int [][] points = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        int [][] queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
        int [] res = new Solution().countPoints(points, queries);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int [] res = new int[queries.length];
        int idx = 0;
        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int r = queries[i][2];
            int count = 0;
            for(int j = 0; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= r) {
                    count++;
                }
            }
            res[idx] = count;
            idx++;
        }
        return res;
    }
}
