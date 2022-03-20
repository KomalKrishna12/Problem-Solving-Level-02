import java.util.*;
// in this question we have given a string str and a pattern we are required to map the 
// pattern to particular string
// eg : str : geekforgeek
//      pattern : pep
//      ans : p -> geek, e -> for
// next p is already printed so no need to print again 
public class Q15_Pattern_matching {
    public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
        // op : original pattern

        // base case
        // when pattern length becomes 0 that means we are at base case
        // now check str length is it is zero then map the op char with their corr str
        if(pattern.length() == 0){
            if(str.length() == 0){
                HashSet<Character> alreadyvisited = new HashSet<>(); // this will check if that char
                // is already printed then no need to print
                for(int i = 0; i < op.length(); i++){
                    char ch = op.charAt(i);
                    if(alreadyvisited.contains(ch) == false){
                        // false that means not printed yet so print ans mark it as visited
                    System.out.print(ch + " -> " + map.get(ch) + ", ");
                    alreadyvisited.add(ch);
                    }
                }
                System.out.println(".");
            }
            return;
        }

		char patternchar = pattern.charAt(0);
        String restofpattern = pattern.substring(1);

        // now check wheather the patternchar is in map or not
        // if yes then check the string that the previous str or the current str is equal or not
        // else map the string for particular patternchar

        if(map.containsKey(patternchar)){
            String prev = map.get(patternchar);
            // now check the str length is equal or greater than prev length or not
            if(str.length() >= prev.length()){
                String left = str.substring(0, prev.length());
                String right = str.substring(prev.length());
                if(prev.equals(left)){
                    solution(right, restofpattern, map, op);
                }
            }
        }
        else{
            // now start creating string for patternchar
            for(int i = 0; i < str.length(); i++){
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);
                map.put(patternchar, left);
                solution(right, restofpattern, map, op);
                map.remove(patternchar);
            }
        }
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
        scn.close();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}
