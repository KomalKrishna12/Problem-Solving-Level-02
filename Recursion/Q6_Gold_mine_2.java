import java.util.*;
public class Q6_Gold_mine_2 {
    static int max = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
        scn.close();
		getMaxGold(arr);
		System.out.println(max);
	}
}
