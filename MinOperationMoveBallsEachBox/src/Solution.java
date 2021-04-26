// You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
//
//In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
//
//Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
//
//Each answer[i] is calculated considering the initial state of the boxes

// For each box, iterate each other box and move the balls inside to index i
// Time: O(n^2), Space: O(n)
class Solution {
    public static void main(String[] args) {
        int [] res = new Solution().minOperations("001011");
        for(int n : res) {
            System.out.print(n + ", ");
        }
    }
    public int[] minOperations(String boxes) {
        int [] res = new int[boxes.length()];
        int index = 0;
        for(int i = 0; i < boxes.length(); i++) {
            int sum = 0;
            for(int j = 0; j < boxes.length(); j++) {
                sum += (boxes.charAt(j) - '0') * Math.abs(i - j);
            }
            res[index++] = sum;
        }
        return res;
    }
}