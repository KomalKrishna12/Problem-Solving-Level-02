import java.io.*;
// in this question we have given total no of boxes and some identical items, we have to place them 
// in the boxes
// if items are identical that means we are required to find out combination
// 4^2 = 4C0 + 4C1 + 4C2 + 4C3 + 4C4    
// for placing 2 identical items into 4 boxes ans will be 4C2 = 6 
public class Q21_Combination_I{
    public static void combinations(int cb, int tb, int ssf, int ts, String asf){
        // base case
        // when cb(current box) > tb(total box) that is our base condition
        // so check ssf and ts if both are equal then print the asf
        if(cb > tb){
            if(ssf == ts) System.out.println(asf);
            return;
        }

        // first call is for placing the item into the box so ssf will increase by 1 and in asf add "i"
        combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
        
        // second call is for not placing the item so ssf will not increase and in asf add "-"
        combinations(cb + 1, tb, ssf, ts, asf + "-");
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
      }
}