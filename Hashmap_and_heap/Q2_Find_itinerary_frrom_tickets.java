import java.util.*;
public class Q2_Find_itinerary_frrom_tickets {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
        scn.close();

		//write your code here
        // 4
        // Chennai  Banglore
        // Bombay   Delhi
        // Goa      Chennai
        // Delhi    Goa
        // so here we are given four tickets from src to destination
        // we are required to calculate the journey from src to destination
        // o/p : Bombay -> Delhi -> Goa -> Chennai -> Banglore
        // so first of all we've to find the starting point
        // for this we created a hashmap of string and boolean
        // for destination put false and if src is not in newly created hashmap then put it with true
        // after this we have our src now run a while loop and print src and make src with it's destination
        // wehen we reach destination then print src with full stop and break
        String src = "";
        HashMap<String, Boolean> potentialSrc = new HashMap<>();
        for(String psrc : map.keySet()){
            potentialSrc.put(map.get(psrc), false);
            if(potentialSrc.containsKey(psrc) == false){
                potentialSrc.put(psrc, true);
            }
        }

        for(String psrc : potentialSrc.keySet()){
            if(potentialSrc.get(psrc)){
                src = psrc;
                break;
            }
        }

        while(true){
            if(map.containsKey(src)){
                System.out.print(src + " -> ");
                src = map.get(src);
            }
            else{
                System.out.print(src + ".");
                break;
            }
        }
        
	}
    // leetcode 332
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> list = new ArrayList<>();

        String src = "";
        HashMap<String, Boolean> potentialSrc = new HashMap<>();

        for(List<String> tic : tickets){
            potentialSrc.put(tic.get(1), false);
            if(potentialSrc.containsKey(tic.get(0)) == false) 
            potentialSrc.put(tic.get(0), true);
        }

        for(String psrc : potentialSrc.keySet()){
            if(potentialSrc.get(psrc)){
                src = psrc;
                break;
            }
        }

        for(List<String> tic : tickets){
            if(tic.get(0) == src){
                list.add(src);
                src = tic.get(1);
            }
            else{
                list.add(src);
                break;
            }
        }

        return list;
    }
}
