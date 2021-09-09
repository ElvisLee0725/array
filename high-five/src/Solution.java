/*
Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.
Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.
A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
*/
/*
- Create a treeMap: <ID, Max heap of scores> by iterating items
- Iterate the treeMap and calculate the 5 score average. Store the result

- Time: O(NlogN), Space: O(N)
*/

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        int [][] input = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int [][] res = new Solution().highFive(input);
        for(int [] arr : res) {
            System.out.println(arr[0] + ", " + arr[1]);
        }

    }
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for(int [] item : items) {
            int ID = item[0];
            int score = item[1];
            map.computeIfAbsent(ID, (x) -> new PriorityQueue<>(Collections.reverseOrder()));
            map.get(ID).offer(score);
        }

        int [][] result = new int[map.size()][2];
        int index = 0;
        for(Integer ID : map.keySet()) {
            result[index][0] = ID;
            int sum = 0;
            for(int i = 0; i < 5; i++) {
                sum += map.get(ID).poll();
            }
            result[index][1] = sum / 5;
            index++;
        }

        return result;
    }
}