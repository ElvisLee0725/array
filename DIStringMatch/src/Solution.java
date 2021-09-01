/*
A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
*/
/*
- Create an array of length s.length+1 with value from 0 to n
- Use 2 pointers left and right representing the lowest and highest unassigned number
- Iterate the string.
    - If it's an 'I', assign left and move left
    - Else, assign right and move right
- At the end, assign the last number and return the array
- Time: O(N), Space: O(N)
*/
class Solution {
    public static void main(String[] args) {
        int [] res = new Solution().diStringMatch("IDID");
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public int[] diStringMatch(String s) {
        int [] res = new int[s.length()+1];

        int left = 0;
        int right = s.length();
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                res[index] = left;
                left++;
            }
            else {
                res[index] = right;
                right--;
            }
            index++;
        }
        res[index] = left;
        return res;
    }
}
