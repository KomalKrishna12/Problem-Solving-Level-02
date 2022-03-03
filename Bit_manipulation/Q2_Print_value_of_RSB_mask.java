import java.util.Scanner;

public class Q2_Print_value_of_RSB_mask {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
    
        int rsb = n & -n;
        System.out.println(Integer.toBinaryString(rsb));
      }
}
