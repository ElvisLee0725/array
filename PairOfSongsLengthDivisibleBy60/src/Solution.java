// You are given a list of songs where the ith song has a duration of time[i] seconds.
//
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
// Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

// Use an array of length 60 to store the frequency of number % 60
// Ex. arr[30] = 1 represents the frequency of remainder of number % 60 is 1
// Iterate the input array:
// If cur number % 60 is 0, add arr[0]
// Else, add arr[60 - current number % 60]
// Increment the remainder of current number % 60 by 1
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
    public int numPairsDivisibleBy60(int[] time) {
        int [] arr = new int[60];
        int counter = 0;
        for(int i = 0; i < time.length; i++) {
            if(time[i] % 60 == 0) {
                counter += arr[0];
            }
            else {
                counter += arr[60 - time[i] % 60];
            }

            arr[time[i] % 60]++;
        }
        return counter;
    }
}
