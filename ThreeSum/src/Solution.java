// Sort the input array
// Use 3 indices i, j and k. j starts from i+1 while k starts from the last index of the array
// In the for loop, check if the combination of array[i], array[j] and array[k] equals target, if so, add to result
// Else, move index j to right if sum is smaller than target, or move k to the left if sum is greater than target.
// Skip all duplicates while moving indices i, j and k.
// Edge Case: input is null or has length < 3

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n^2), Space: O(n)
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 2, 2, 3, 2, 4};
        List<List<Integer>> res = new Solution().allTriples(arr, 8);
        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> res = new ArrayList();
        if(array == null || array.length < 3) {
            return res;
        }
        Arrays.sort(array);

        for(int i = 0; i < array.length - 2; i = moveLeft(i, array)) {
            int j = i + 1;
            int k = array.length - 1;
            while(j < k) {
                int sum = array[i] + array[j] + array[k];
                if(sum == target) {
                    res.add(new ArrayList(Arrays.asList(array[i], array[j], array[k])));
                    j = moveLeft(j, array);
                    k = moveRight(k, array);
                }
                else if(sum < target) {
                    j = moveLeft(j, array);
                }
                else {
                    k = moveRight(k, array);
                }
            }
        }
        return res;
    }

    public int moveLeft(int index, int [] arr) {
        while(index < arr.length - 1 && arr[index] == arr[index+1]) {
            index++;
        }
        return index + 1;
    }

    public int moveRight(int index, int [] arr) {
        while(index > 0 && arr[index] == arr[index-1]) {
            index--;
        }
        return index - 1;
    }
}
