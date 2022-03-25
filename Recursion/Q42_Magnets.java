import java.util.*;
public class Q42_Magnets {
    public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
                                 int row, int col) {

    //write your code here

    return false;
  }

  public static void print(char[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int m = scn.nextInt();
    int n = scn.nextInt();
    char[][] arr = new char[m][n];
    for (int i = 0; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int[] top = new int[n];
    for (int i = 0; i < n; i++) {
      top[i] = scn.nextInt();
    }
    int[] left = new int[m];
    for (int i = 0; i < m; i++) {
      left[i] = scn.nextInt();
    }
    int[] right = new int[m];
    for (int i = 0; i < m; i++) {
      right[i] = scn.nextInt();
    }
    int[] bottom = new int[n];
    for (int i = 0; i < n; i++) {
      bottom[i] = scn.nextInt();
    }
    scn.close();

    //write your code here
  }
}
