// A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.

// You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed in the testing
// sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time the ith key was released. Both
// arrays are 0-indexed. The 0th key was pressed at the time 0, and every subsequent key was pressed at the
// exact time the previous key was released.

// The tester wants to know the key of the keypress that had the longest duration. The ith keypress had a duration of
// releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].

// Note that the same key could have been pressed multiple times during the test, and these multiple presses of the
// same key may not have had the same duration.

// Return the key of the keypress that had the longest duration. If there are multiple such keypresses, return the
// lexicographically largest key of the keypresses.



public class Solution {
    public static void main(String[] args) {
        int [] release = new int[]{9,29,49,50};
        System.out.print(new Solution().slowestKey(release, "cbcd"));
    }
    // Use an array of length 26 to represent the highest duration of letter from a to z
// Loop the releaseTimes array and update the duration of each letter if the current letter has higher duration
// Loop the array and update the char with highest duration -> Ex. index 3 => 'd'
// Time: O(n), Space: O(1)

        public char slowestKey(int[] releaseTimes, String keysPressed) {
            int [] arr = new int[26];
            for(int i = 0; i < releaseTimes.length; i++) {
                if(i == 0) {
                    arr[keysPressed.charAt(0) - 'a'] = releaseTimes[0];
                }
                else {
                    arr[keysPressed.charAt(i) - 'a'] = Math.max(arr[keysPressed.charAt(i)-'a'], releaseTimes[i] - releaseTimes[i-1]);
                }
            }

            char max = 'a';
            int maxDuration = arr[0];
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] >= maxDuration) {
                    max = (char)('a' + i);
                    maxDuration = arr[i];
                }
            }
            return max;
        }
}
