import java.util.*;
// in this questing we have given n whihc is no of string separated by spaces
// then we have given n no strings which is added in a hashset
// now we have given a long string created using those n strings
// we are required to print all possbile sentance which can be created
// eg :
// n : 11
// n strings : i like pep coding pepper eating mango man go in pepcoding
// string created using n strings : ilikepeppereatingmangoinpepcoding
// ans : we can see in n strings we have pep coding as well as pepcoding so we can create two 
// sentence with these two words, then we have man go and mango so again we can create two more sentences
// so our ans will be
// i like pepper eating mango in pepcoding
// i like pepper eating mango in pep coding
// i like pepper eating man go in pepcoding
// i like pepper eating man go in pep coding
// so total we have these 4 sentences
public class Q16_Word_break_I {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
        scn.close();
		wordBreak(sentence,"", dict);
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict){
		// base case
        // when str length becomes 0 print the ans and return
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // start creating prefix string and search the string into dict hashset
        // if it is in hashset then find rest string and call wordBreak with rest string as str
        // ans add prefix into ans with space
        for(int i = 0; i < str.length(); i++){
            String prefix = str.substring(0, i+1);
            if(dict.contains(prefix)){
                String ros = str.substring(i+1);
                wordBreak(ros, ans + prefix + " ", dict);
            }
        }
	}
}
