import java.util.*;
public class Q4_Count_Distinct_element_in_window_of_k {
    public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here
		ArrayList<Integer> list = new ArrayList<Integer>();

        // create a hashmap and add k-1 elements into the map with their frequency
        // now do this 3 step - add -> display -> remove
        // add kth element
        // count the size of ma
        // and remove first elment of k length window 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        
        for(int i = 0, j = k-1; j < arr.length;){
            map.put(arr[j], map.getOrDefault(arr[j],0) + 1);
            
            list.add(map.size());
            
            int fr = map.get(arr[i]);
            if(fr == 1){
                map.remove(arr[i]);
            }
            else{
                map.put(arr[i], fr - 1);
            }
            i++;
            j++;
        }

		return list;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
        scn.close();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}
}
