// Without sorting
// Use a array of length 100000, arr[i] is the number of ice creams at price i
// Iterate the array, if the arr[i] is greater than 0, start buying ice cream until buy out or run out of money
// Return the count
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        int [] c = new int[]{1,6,3,1,2,5};
        System.out.println(new Solution().maxIceCream(c, 20));
    }
    public int maxIceCream(int[] costs, int coins) {
        int [] arr = new int[100001];
        for(int i = 0; i < costs.length; i++) {
            arr[costs[i]]++;
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                for(int j = 0; j < arr[i]; j++) {
                    if(coins >= i) {
                        count++;
                        coins -= i;
                    }
                    else {
                        break;
                    }
                }
            }
            // If run out of coins or cannot afford anymore, break;
            if(coins == 0 || coins < i) {
                break;
            }
        }
        return count;
    }
}
