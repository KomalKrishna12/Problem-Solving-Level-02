import java.util.Scanner;
// in this ques we have given a no n we are required to calculate total no of on switch, means 1's
// we can use Kernighan's algo in this
// calcuate rsb and subtract rsb from n and increase the count of ans
// and do this till our no is not equal to 0
// rsb will convert all digit into 0 except the last 1 so add that 1 count and subtract from n and again
// calculate rsb
public class Q3_Kernighans_algorithm {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        
        //write your code here
        int count = 0;
        while(n != 0){
            int rsb = n & -n;
            n -= rsb;
            count++;
        }
        System.out.println(count);
      }
}
