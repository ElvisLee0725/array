// X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
// A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
// Now given a positive number N, how many numbers X from 1 to N are good?

// For each number from 1 to N,
// If the number contains 3, 4, or 7, we can go check the next number
// Else if the number contains any 2, 5, 6, and 9 in all its digit? If so, found is true
// After the while loop, check if found? If so, count++
// Return count after the loop
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(10));
    }
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++) {
            boolean found = false;
            int cur = i;
            while(cur > 0) {
                int curDigit = cur % 10;
                if(curDigit == 3 || curDigit == 4 || curDigit == 7) {
                    found = false;
                    break;
                }
                else if(curDigit == 2 || curDigit == 5 || curDigit == 6 || curDigit == 9) {
                    found = true;
                }

                cur /= 10;
            }
            if(found) {
                count++;
            }
        }
        return count;
    }
}
