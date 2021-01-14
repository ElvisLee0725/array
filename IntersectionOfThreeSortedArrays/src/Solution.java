import java.util.ArrayList;
import java.util.List;
// Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of
// only the integers that appeared in all three arrays.

public class Solution {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {1,2,5,7,9};
        int [] arr3 = {1,3,4,5,8};
        List<Integer> res = new Solution().arraysIntersection(arr1, arr2, arr3);
        for(Integer n : res) {
            System.out.print(n + " ");
        }
    }

    // Use 3 pointers i, j and k to point at the begining of each array
    // While they are not exceeding the range of array each one is pointing, check:
    // Case 1: arr[i] == arr[j] == arr[k], add to the result arraylist, move i, j and k by 1
    // Case 2: Move the index pointing at smaller value by 1
    // Time: O(n), Space: O(1)

        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            int i = 0;
            int j = 0;
            int k = 0;
            List<Integer> res = new ArrayList();
            while(i < arr1.length && j < arr2.length && k < arr3.length) {
                if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                    res.add(arr1[i]);
                    i++;
                    j++;
                    k++;
                }
                else {
                    if(arr1[i] < arr2[j] || arr1[i] < arr3[k]) {
                        i++;
                    }
                    else if(arr2[j] < arr1[i] || arr2[j] < arr3[k]) {
                        j++;
                    }
                    else if(arr3[k] < arr1[i] || arr3[k] < arr2[j]) {
                        k++;
                    }
                }
            }
            return res;
        }
}
