import java.io.*;
// this is same ques like Q20 permutation_I
// but here we use combination_I approach to find permuattion
// so for combination we have identical items but in permuation we have diff items
// so i is from (1 to r) r is total items
// so here we call recursion r + 1 times suppose r is 2 and n = 3 so we call 3 times
// 1 for 1st item, 2 for 2nd item then for 0 
public class Q22_Permutation_2 {
    public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){
        if(cb > tb){
            if(ssf == ts) System.out.println(asf);
            return;
        }

        // this loop traverse for ts which is total no of items so while adding is ssf we add(i+1)
        // bcoz loop start from 0 so we can get items element easily
        for(int i = 0; i < ts; i++){
            if(items[i] == 0){
                items[i] = 1;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                items[i] = 0;
            }
        }

        // this call is for when we don't want to place any item so add 0 into ssf
        permutations(cb + 1, tb, items, ssf, ts, asf + "0");  
      }
     
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
      }
}
