import java.util.*;
// given two integer n and k, n is no of elements and k is no of subsets
// we have to configue n elements into k subsets

public class Q11_K_Partitions{
    static int count = 1; // used to print subsets in a sequences
    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		// base case
        // if i > n, check rssf if equals to k that means n created k no of subsets so
        // print them and return
        if(i > n){
            if(k == rssf){
                System.out.print(count + ". ");
                for(ArrayList<Integer> list : ans){
                    System.out.print(list + " ");
                }
                System.out.println();
                count++;
            }
            return;
        }

        // if k is 3 that means we have to create ans list of 3 lists so j is used to fetch 0 to 3
        // and in two ways
        // first : add i into prev list so their will be no increament into the subset
        // second : add into empty place so rssf will increase by 1
        for(int j = 0; j < ans.size(); j++){
            // check size of list at jth index
            // if greater than 0 then add into prev subsets
            // if 0 then add into new subset 
            if(ans.get(j).size() > 0){
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            }
            else{
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break; // break so it'll not create any duplicate subset
            }
        }
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
        scn.close();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}
}