import java.util.*;
// in this question, we've given an array
// we're required to count the total no of equivalent subarrays
// equivalent subarray means subarray contains all unique integers
public class Q14_count_of_equivalent_subarrays{

    // create a HashSet and add all elements of array
    // now store size of hashset into k that is the total unique elments of array
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
            set.add(arr[i]);
        }
        scn.close();
        int k = set.size();

        // create a hashmap which contains frequency of each integers
        // in ans we'll store count of quivalent subarrays
        // create a while loop
        // inside it create two while loop one for acquire and second for release
        int i = -1, j = -1, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(true){
            boolean f1 = false, f2 = false;

            // add elements into map
            // when map size equals to k then calculate total no of subarrays and break
            // total no of subarrays = length of array - i
            // i is the index where we got our first equivalent subarray
            // so that is the smallest subarray after than each element will make subarray
            while(i < arr.length - 1){
                f1 = true;
                i++;
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

                if(map.size() == k){
                    ans += arr.length - i;
                    break;
                }
            }

            // remove jth element from map if that's ocuurence is 1 else decrese it's occurence by 1
            // now check the map size equal to k or not, if yes then calculate subarray else break
            while(j < i){
                f2 = true;
                j++;
                if(map.get(arr[j]) == 1){
                    map.remove(arr[j]);
                }
                else{
                    map.put(arr[j], map.get(arr[j]) - 1);
                }

                if(map.size() == k){
                    ans += arr.length - i;
                }
                else{
                    break;
                }
            }

            if(f1 == false && f2 == false) break;
        }

		System.out.println(ans);
	}
}