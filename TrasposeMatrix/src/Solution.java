public class Solution {
    public static void main(String[] args) {
        int [][] m = {{1,2,3},{4,5,6}};
        int [][] res = new Solution().transpose(m);
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
                if(j != res[0].length-1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public int[][] transpose(int[][] A) {
        int [][] t = new int[A[0].length][A.length];
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                t[i][j] = A[j][i];
            }
        }
        return t;
    }
}
