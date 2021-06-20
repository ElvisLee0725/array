public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{0, 1, 1, 0, 1, 1, 1, 0};
        new Solution().sortBitArray(arr);
        for(int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public void sortBitArray(int [] arr) {
        int numZero = 0;
        int numOne = 0;
        for(int i : arr) {
            if(i == 0) {
                numZero++;
            }
            else {
                numOne++;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if(numZero > 0) {
                arr[i] = 0;
                numZero--;
            }
            else {
                arr[i] = 1;
            }
        }
    }
}
