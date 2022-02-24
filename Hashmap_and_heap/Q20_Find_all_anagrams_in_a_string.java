import java.util.*;
// in this question we have given two string s is source and p is pattern
// we're required to print total no of anagrams and start index of anagrams
// anagrams means the source string is having same occurence of characters like pattern
public class Q20_Find_all_anagrams_in_a_string {
    // instead of this function we can direct use s.equals(p) function
    public static boolean compareMaps(HashMap<Character, Integer> s, HashMap<Character, Integer> p){
        for(char pch : p.keySet()){
            if(s.getOrDefault(pch, 0) != p.get(pch)){
                return false;
            }
        }
        return true;
    }
    public static void findAnagrams(String s, String p) {
        // firstly store pattern into pmap
        // then store pattern length characters from starting into smap
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        
        int count = 0; // count of tota anagrams
        String indexes = ""; // starting index of each anagrams

        for(int i = 0; i < p.length(); i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }

        // till pth length smap contains elements so start traversing from p.length
        int i = p.length();

        while(i < s.length()){
            // compare both maps
            // if same then increase the count and store starting index
            if(smap.equals(pmap)){
                count++;
                indexes += (i - p.length()) + " ";
            }

            // acquire
            char cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha, 0) + 1);

            //release
            char chr = s.charAt(i - p.length());
            if(smap.get(chr) == 1) smap.remove(chr);
            else smap.put(chr, smap.get(chr) - 1);

            i++;

        }

        // once i comes at last index, loop will stop executing, so we've to check last time 
        if(smap.equals(pmap)){
            count++;
            indexes += (i - p.length()) + " ";
        }

        System.out.println(count);
        System.out.println(indexes);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
        scn.close();
		findAnagrams(s, p);
	}
}
