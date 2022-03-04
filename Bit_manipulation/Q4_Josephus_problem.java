import java.util.Scanner;

public class Q4_Josephus_problem {
    public static int powerOf2(int n){
        int i = 1;

        while (i * 2 <= n) {
            i = i * 2;
        }

        return i;
    }
    public static int solution(int n){
        int highPowof2 = powerOf2(n);
        int l = n - highPowof2;
        return 2 * l + 1;
      }
      public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(n));
      }
}
