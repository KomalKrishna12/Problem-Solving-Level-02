import java.io.*;
import java.util.HashMap;
// this is similar ques like q29 we have to make dsu or pair array and then we start checking
// for sentence1 and sentence2
// here instead of int array we use hashmap bcoz we want to store string as parent and rank as string count
public class Q30_Sentence_similarity {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    
        String[] sentence1 = br.readLine().split(" ");
        String[] sentence2 = br.readLine().split(" ");
    
        int m = Integer.parseInt(br.readLine());
    
        String[][] pairs = new String[m][2];
        for (int i = 0; i < m; i++) {
          pairs[i] = br.readLine().split(" ");
        }
    
        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));
        System.out.println(n);
    
      }

      // create HashMap for parent and rank
      // by default we'were storing par[i] = i and rank as 1 but here we will store it in find
      // function
      static HashMap<String, String> par;
      static HashMap<String, Integer> rank;
    
      public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
        par = new HashMap<>(); 
        rank = new HashMap<>();

        if(Sentence1.length != Sentence2.length) return false;

        for(String[] pair : pairs){
            union(pair[0], pair[1]); // merging all pairs, dsu is done here
        }

        for(int i = 0; i < Sentence1.length; i++){
            String word1 = Sentence1[i];
            String word2 = Sentence2[i];

            // now compare both words, if they're not equal according to dsu then return false
            // else return true at end 
            if(word1.equals(word2) == false && find(word1).equals(find(word2)) == false) 
            return false;
        }

        return true;
      }

      public static String find(String x){
        if(par.containsKey(x) == false){
            par.put(x, x);
            rank.put(x, 1);
        }

        if(par.get(x).equals(x)) return x;

        String temp = find(par.get(x));
        par.put(x, temp);
        return temp;
      }

      public static void union(String x, String y){
        String lx = find(x);
        String ly = find(y);

        if(lx != ly){
            if(rank.get(lx) > rank.get(ly)){
                par.put(ly, lx);
            }
            else if(rank.get(lx) < rank.get(ly)){
                par.put(lx, ly);
            }
            else{
                par.put(lx, ly);
                rank.put(ly, rank.get(ly) + 1);
            }
        }
      }

    }
