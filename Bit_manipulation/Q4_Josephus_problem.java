import java.util.Scanner;
// in the ques we have given n solders standing in circular from 1 to n
// king want to kill every second solders like 1 will safe 2 will killed 3 will be safe 4 will be killed
// so solders will become less at end when only one solder left that will give freedom any we are rquired
// to find out that soldrs
// n = 2^x + l and ans = 2*l + 1
// break n into pow of 2 and calculate l
// n = 18
// n = 2^4 + 2 here l is 2 so ans will be 2*2 + 1 = 5
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
