import java.util.Scanner;

public class Q1_Basics_of_bit_manipulation{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();
        scn.close();
        
        int onmask = 1 << i; 
        int offmask = ~(1 << j);
        int togmask = 1 << k;
        int cmask = 1 << m;

        System.out.println(n | onmask);
        System.out.println(n & offmask);
        System.out.println(n ^ togmask);
        System.out.println((n & cmask) == 0 ? false : true);
      }
}