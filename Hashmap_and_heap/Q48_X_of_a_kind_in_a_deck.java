import java.util.Scanner;

public class Q48_X_of_a_kind_in_a_deck {
    public static boolean hasGroupsSizeX(int[] deck) {
        // write your code here
        return true;
      }
    
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(hasGroupsSizeX(arr));
      }
}
