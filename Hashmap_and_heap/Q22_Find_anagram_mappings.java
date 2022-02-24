import java.util.*;
// in the question we have given two string both are anagram of each other
// we are required to map them
// map means element of arr1 is present at ith index of arr2 so ith index is the mapping of element of
// arr1
// {arr1[i] ka value arr2[i] mai dhundna hai or uska index store krna hai ans[i] mai}
public class Q22_Find_anagram_mappings {
    static class Pair{
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
    }
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
        // create a hashmap of integer and class pair type
        // traverse in arr2
        // if map contains arr2[i] then add the index into the list of arr2[i]
        // else create a pair, add index to its list and put it into map
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i < arr2.length; i++){
            if(map.containsKey(arr2[i])){
                Pair p = map.get(arr2[i]);
                p.list.add(i);
            }
            else{
                Pair p = new Pair();
                p.list.add(i);
                map.put(arr2[i], p);
            }
        }
        // create a ans array which will store the maped index with respect to arr1
		int[] ans = new int[arr1.length];

        // get the index and list for arr1[i] and store the index of particular element into ans array
        for (int i = 0; i < arr1.length; i++) {
            Pair p = map.get(arr1[i]);
            ans[i] = p.list.get(p.index);
            p.index++;
        }

        return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
        s.close();
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}
}
