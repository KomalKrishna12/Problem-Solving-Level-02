import java.util.*;
// in thr question we have given deck array and we are required to group the array so that each group size
// will be equal and group elements should be same
public class Q48_X_of_a_kind_in_a_deck {
    // we can create a map and add all the element with it's frequency
    // now find out the gcd of values of map 
    // if gcd is greater than 1 that means it can be grouped so return true else return false
    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : deck){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int gcd = 0;
        for(int val : map.keySet()){
            gcd = gcd(gcd, map.get(val));
        }

        if(gcd > 1) return true;
        return false;
      }

      // Euclid's algorthim for GCD
      // gcd(a,b) = gdc(b,a%b)
      // base case : if gcd(a,0) when b is 0 then gcd will be a
      public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b,a%b);
      }
    
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(hasGroupsSizeX(arr));
      }
}
