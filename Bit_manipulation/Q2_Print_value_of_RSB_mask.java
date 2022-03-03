import java.util.Scanner;
// RSB means right most set bit mask
// so in this question we have given a number n
// we are required to find out its RSB
// RSB is the msb of binary no, means last 1's, after this in the binary no only 0's are present
// RSB = n & n"
// n" : two complement
// n" = n' + 1;
// n' : ones complement
// n" == -n
public class Q2_Print_value_of_RSB_mask {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
    
        int rsb = n & -n;
        System.out.println(Integer.toBinaryString(rsb));
      }
}
