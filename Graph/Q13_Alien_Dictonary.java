import java.io.*;
import java.util.*;
public class Q13_Alien_Dictonary {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] words = br.readLine().split(" ");
    
        System.out.println(alienOrder(words));
      }
    
      public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();
    
        for (String s : words) {
          for (char ch : s.toCharArray()) {
            degree.put(ch, 0);
          }
        }
    
        for (int i = 0; i < words.length - 1; i++) {
          String curr = words[i];
          String next = words[i + 1];
          boolean flag = false;
          int len = Math.min(curr.length(), next.length());
          for (int j = 0; j < len; j++) {
            char ch1 = curr.charAt(j);
            char ch2 = next.charAt(j);
            if (ch1 != ch2) {
              HashSet<Character> set = new HashSet<>();
              if (graph.containsKey(ch1) == true) {
                set = graph.get(ch1);
                if (set.contains(ch2) == false) {
                  set.add(ch2);
                  degree.put(ch2, degree.get(ch2) + 1);
                  graph.put(ch1, set);
                }
              }
              else {
                set.add(ch2);
                degree.put(ch2, degree.get(ch2) + 1);
                graph.put(ch1, set);
              }
              flag = true;
              break;
    
            }
          }
          if (flag == false && curr.length() > next.length()) return "";
        }
        
        ArrayDeque<Character> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : degree.keySet()){
            if(degree.get(ch) == 0) queue.add(ch);
        }
        
        int count = 0;
        
        while(queue.size() > 0){
            char rem = queue.removeFirst();
            sb.append(rem);
            count++;
            if(graph.containsKey(rem) == true){
                HashSet<Character> nbrs = graph.get(rem);
                for(char nbr : nbrs){
                    degree.put(nbr, degree.get(nbr) - 1);
                    if(degree.get(nbr) == 0) queue.add(nbr);
                }
            }
        }
        
        if(count == degree.size()) return sb.toString();
        return "";
        
      }
}
