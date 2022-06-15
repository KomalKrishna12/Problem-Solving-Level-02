import java.io.*;
import java.util.*;
public class Q13_Alien_Dictonary {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] words = br.readLine().split(" ");
    
        System.out.println(alienOrder(words));
      }
    
      public static String alienOrder(String[] words) {
          // create two maps one for graph and one for indegree
          // firstly set indegree as 0 for every char
          HashMap<Character, HashSet<Character>> graph = new HashMap<>();
          HashMap<Character, Integer> indegree = new HashMap<>();

          for(String s : words){
              for(char ch : s.toCharArray()){
                  indegree.put(ch, 0);
              }
          }

          // now compare two strings and add into graph
          for(int i = 0; i < words.length - 1; i++){
              String curr = words[i];
              String next = words[i+1];
              boolean flag = false;

              // len will store min length so it'll compare till that 
              int len = Math.min(curr.length(), next.length());

              for(int j = 0; j < len; j++){
                  char ch1 = curr.charAt(j);
                  char ch2 = next.charAt(j);
                  if(ch1 != ch2){
                      // if char not matching that means here we can add that into graph so check
                      // if that char is already their than add it into the previous set and increase 
                      // indegree
                      HashSet<Character> set = new HashSet<>();
                      if(graph.containsKey(ch1) == true){
                          set = graph.get(ch1);
                          if(set.contains(ch2) == false){
                              set.add(ch2);
                              indegree.put(ch2, indegree.get(ch2) + 1);
                              graph.put(ch2, set);
                          }
                      }
                      else{
                        set.add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                        graph.put(ch2, set);
                      }
                      flag = true;
                      break;
                  }
              }

              // suppose curr : abcd and next : abc
              // here len = 3 and till 3 all chars are same but this is not same so return empty string
              if(flag == false && curr.length() > next.length()) return "";
          }

          // now create a queue and add all 0 indegree characters
          // start removing charcaters and decrese their indegree by 1 and if indegree is 0 then
          // add it into queue
          ArrayDeque<Character> queue = new ArrayDeque<>();
          StringBuilder sb = new StringBuilder();

          for(char ch : indegree.keySet()){
              if(indegree.get(ch) == 0)
              queue.add(ch);
          }

          int count = 0;

          while(queue.size() > 0){
              char rem = queue.removeFirst();
              count++;
              sb.append(rem);
              if(graph.containsKey(rem)){
                  HashSet<Character> nbrs = graph.get(rem);
                  for(char nbr : nbrs){
                      indegree.put(nbr, indegree.get(nbr) - 1);
                      if(indegree.get(nbr) == 0) 
                      queue.add(nbr);
                  }
              }
          }

          if(count == indegree.size()) return sb.toString();
          else return "";
      }
}
