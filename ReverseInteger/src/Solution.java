// Given a 32-bit signed integer, reverse digits of an integer.
// Note:
// Assume we are dealing with an environment that could only store integers within the 32-bit signed
// integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function
// returns 0 when the reversed integer overflows.

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().reverse(12345678));
    }
    // Be careful if the reversed number is overflown
// While x != 0, store the current result, and then the result * 10 + the last digit of x
// Check if I can get the prior result back? If not, it's overflow, return 0
// Divide x by 10 before the end of while loop
// Return result after the while loop

        public int reverse(int x) {
            int res = 0;
            while(x != 0) {
                int prior = res;
                res = res * 10 + (x % 10);
                if((res - x % 10) / 10 != prior) {
                    return 0;
                }
                x /= 10;
            }
            return res;
        }
}
