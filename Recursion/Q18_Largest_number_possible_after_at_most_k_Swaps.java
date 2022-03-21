import java.util.*;
// we have given a string str which is a digits of numer and we have given k 
// we have to swap 4 digits of str and make max string 
public class Q18_Largest_number_possible_after_at_most_k_Swaps {
    static String max;
	public static void findMaximum(String str, int k) {
	    if(Integer.parseInt(str) > Integer.parseInt(max)) max = str; // compare max with str
	    
	    if(k == 0) return; // when k is 0 return
		
        // outer loop will compare i with inener loop where j = i + 1
        // if jth char is greater than ith char then swap them
		for(int i = 0; i < str.length() - 1; i++){
		    for(int j = i + 1; j < str.length(); j++){
		        if(str.charAt(j) > str.charAt(i)){
		            str = swap(str, i, j);
		            findMaximum(str, k - 1);
		            str = swap(str, i, j);
		        }
		    }
		}
		
	}
    // for swapping fisrtly store the ith char and jth char
    // now find left string which is from 0 to i-1 so we use substring(o,i) so it'll not consider ith
    // in mid string from i+1 to j-1
    // in right j+1 to end
    // now return left + jth + mid + ith + right so our ith and jth will be swapped 
	public static String swap(String str, int i, int j){
	    char ith = str.charAt(i);
	    char jth = str.charAt(j);
	    String left = str.substring(0, i);
	    String mid = str.substring(i+1, j);
	    String right = str.substring(j+1);
	    return left + jth + mid + ith + right;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
        scn.close();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}
}
