// Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:
//
//In the beginning, you have the permutation P=[1,2,3,...,m].
//For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i].
//Return an array containing the result for the given queries.

import java.util.HashMap;

// Use DLL and HashMap<Number, DLL>
// Iterate the queries array, for the target number, iterate the DLL to find its position and store it
// Then, remove that target from DLL and insert back in head
// Time: O(nm), Space: O(m)
class Solution {
    public static void main(String[] args) {
        int [] q = new int[]{3,1,2,1};
        int [] res = new Solution().processQueries(q, 5);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int n) {
            this.val = n;
            this.prev = null;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;
    public int[] processQueries(int[] queries, int m) {
        HashMap<Integer, Node> map = new HashMap();
        for(int i = 1; i <= m; i++) {
            Node cur = new Node(i);
            if(head == null && tail == null) {
                head = cur;
                tail = cur;
            }
            else {
                tail.next = cur;
                cur.prev = tail;
                tail = tail.next;
            }
            map.put(i, cur);
        }

        int [] res = new int[queries.length];
        int index = 0;
        for(int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int counter = 0;
            Node cur = head;
            while(cur != null) {
                if(cur.val == target) {
                    res[index] = counter;
                    index++;
                    break;
                }
                cur = cur.next;
                counter++;
            }
            remove(map.get(target));
            insert(target, map);
        }
        return res;
    }
    private void remove(Node n) {
        if(n == head) {
            head = head.next;
        }
        if(n == tail) {
            tail = tail.prev;
        }
        if(n.next != null) {
            n.next.prev = n.prev;
        }
        if(n.prev != null) {
            n.prev.next = n.next;
        }
        n.prev = null;
        n.next = null;
    }

    private void insert(int target, HashMap<Integer, Node> map) {
        Node n = new Node(target);
        if(head == null && tail == null) {
            head = n;
            tail = n;
        }
        else {
            n.next = head;
            head.prev = n;
            head = head.prev;
        }

        map.put(target, n);
    }
}
