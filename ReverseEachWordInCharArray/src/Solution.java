public class Solution {
    public static void main(String[] args) {
        char [] arr = new char[]{'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't'};
        char [] arr1 = new char[]{' ', ' '};
        char [] res = new Solution().reverseWords(arr1);

        for(char c : res) {
            System.out.print(c + " ");
        }
    }

    public char [] reverseWords(char [] arr) {
        if(arr == null || arr.length == 0) {
            return arr;
        }

        swap(0, arr.length-1, arr);

        int s = 0;
        int e = 0;
        while(e < arr.length) {
            while(e < arr.length - 1 && arr[e+1] != ' ') {
                e++;
            }
            swap(s, e, arr);
            s = e + 2;
            e = s;
        }
        return arr;
    }

    public void swap(int i, int j, char [] arr) {
        while(i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
