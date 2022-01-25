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
}
