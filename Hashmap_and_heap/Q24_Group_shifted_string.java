import java.util.*;
// in this question, we've given an array of strings
// we're required to group them according to their ascii value 
public class Q24_Group_shifted_string {

    // to key is the gap between the ascii value
    // str : acd
    // gap between a and c : 3 - 1 = 2
    // gap between d and c : 4 - 3 = 1
    // key will be : 2#1#. # denotes space and . denotes end
    // ex2 str : yab
    // a - y = 1 - 25 = -24 it is negetive so add 26 so diff becomes 2
    // b - 1 = 2 - 1 = 1
    // key = 2#1#.
    public static String getKey(String str){
        String key = "";

        for(int i = 1; i < str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            int diff = curr - prev;
            if(diff < 0) diff += 26;
            key += diff + "#";
        }

        key += ".";

        return key;
    }

    // create a hashmap of string(key which we created in getKey()) and list(it'll add all strings of
    // same key)
    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // create loop for strs[]
        // firstly create key
        // now check map
        // if key exists then get list for that key and add the str into list
        // else create a list, add str into list and put into map
        for(String str : strs){
            String key = getKey(str);
            if(map.containsKey(key) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
            else{
                ArrayList<String> list = map.get(key);
                list.add(str);
            }
        }

        // now we want to store all list into list of list so use values() function to fetch all list
        // add it into ans list
        for(ArrayList<String> list : map.values()){
            ans.add(list);
        }

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
        sc.close();
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}
}
