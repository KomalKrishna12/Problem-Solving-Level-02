import java.util.*;
public class Q8_Crossword_puzzle {
    public static void solution(char[][] arr, String[] words, int vidx) {
        //write your code here
    
      }
    
    
      public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
          for (int j = 0 ; j < arr.length; j++) {
            System.out.print(arr[i][j]);
          }
          System.out.println();
        }
    
      }
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0 ; i < arr.length; i++) {
          String str = scn.next();
          arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i  < words.length; i++) {
          words[i] = scn.next();
        }
        scn.close();
        solution(arr, words, 0);
      }
}
