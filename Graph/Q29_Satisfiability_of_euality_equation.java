import java.io.*;
public class Q29_Satisfiability_of_euality_equation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
          arr[i] = br.readLine();
        }
    
        System.out.println(equationsPossible(arr));
      }

      static int[] par;
      static int[] rank; 
    
      public static boolean equationsPossible(String[] equations) {
        par = new int[26];
        rank = new int[26];

        for(int i = 0; i < 26; i++){
            par[i] = i;
            rank[i] = 1;
        }

        for(String eq : equations){
            if(eq.charAt(1) == '='){
                union(eq.charAt(0)-'a', eq.charAt(3)-'a');
            }
        }

        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int lx = find(eq.charAt(0)-'a');
                int ly = find(eq.charAt(3)-'a');

                if(lx == ly) return false;
            }
        }
        return true;
      }

      public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                par[ly] = lx;
            }
            else if(rank[ly] > rank[lx]){
                par[lx] = ly;
            }
            else{
                par[lx] = ly;
                rank[ly]++;
            }
        }
      }

      public static int find(int x){
        if(x == par[x]) return x;
        else return par[x] = find(par[x]);
      }
}
