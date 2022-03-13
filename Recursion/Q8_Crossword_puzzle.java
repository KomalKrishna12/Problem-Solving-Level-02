import java.util.*;

public class Q8_Crossword_puzzle {
    public static void solution(char[][] arr, String[] words, int vidx) {

        // base case
        if (vidx == words.length) {
            print(arr);
            return;
        }

        String word = words[vidx];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {

                    if (canPlaceHorizontally(arr, word, i, j)) {
                        boolean[] weCan = placeHorizontally(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceHorizontally(arr, weCan, i, j);
                    }

                    if (canPlaceVertically(arr, word, i, j)) {
                        boolean[] weCan = placeVertically(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceVertically(arr, weCan, i, j);
                    }

                }

            }

        }

    }

    public static void unplaceHorizontally(char[][] arr, boolean[] weCan, int i, int j){

        for(int jj = 0; jj < weCan.length; jj++){
            if(weCan[jj]) arr[i][j + jj] = '-';
        }

    }

    public static void unplaceVertically(char[][] arr, boolean[] weCan, int i, int j){

        for(int ii = 0; ii < weCan.length; ii++){
            if(weCan[ii]) arr[i + ii][j] = '-';
        }

    }

    public static boolean[] placeHorizontally(char[][] arr, String word, int i, int j){

        boolean[] weCan = new boolean[word.length()];

        for(int jj = 0; jj < word.length(); jj++){

            if(arr[i][j + jj] == '-'){
                arr[i][j + jj] = word.charAt(jj);
                weCan[jj] = true;
            }

        }

        return weCan;

    }

    public static boolean[] placeVertically(char[][] arr, String word, int i, int j){

        boolean[] weCan = new boolean[word.length()];

        for(int ii = 0; ii < word.length(); ii++){

            if(arr[i + ii][j] == '-'){
                arr[i + ii][j] = word.charAt(ii);
                weCan[ii] = true;
            }

        }

        return weCan;

    }

    public static boolean canPlaceHorizontally(char[][] arr, String word, int i, int j){

        if(j - 1 >= 0 && arr[i][j - 1] != '+') return false; // check one index before and after

        if(j + word.length() < arr.length && arr[i][j + word.length()] != '+') return false;

        for(int jj = 0; jj < word.length(); jj++){

            if(j + jj >= arr.length) return false;
            
            if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) continue;

            else return false;

        }

        return true;

    }

    public static boolean canPlaceVertically(char[][] arr, String word, int i, int j){

        if(i - 1 >= 0 && arr[i - 1][j] != '+') return false; // check one index before and after

        if(i + word.length() < arr.length && arr[i + word.length()][j] != '+') return false;

        for(int ii = 0; ii < word.length(); ii++){

            if(i + ii >= arr.length) return false;
            
            if(arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) continue;

            else return false;

        }

        return true;

    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        scn.close();
        solution(arr, words, 0);
    }
}
