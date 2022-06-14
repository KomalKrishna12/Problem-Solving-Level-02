import java.io.*;
import java.util.Arrays;
// we have given an array, we've to sort the array in min cycle
// so we create a pair class array in which we store value with index
// now craeet a boolean array
// start traversing in both arrays
public class Q10_Min_no_of_swaps_required_to_sort_an_array {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
    
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(st[i]);
        }
    
        System.out.println(minSwaps(arr));
      }
    
      public static int minSwaps(int[] arr1) {
          int n = arr1.length;

          // create a Pair class array and store values with index
          // and sort the array based on their values
          Pair[] arr = new Pair[n];

          for(int i = 0; i < n; i++){
              arr[i] = new Pair(arr1[i], i); // storing value of arr1 into arr with index
          }

          // sort
          Arrays.sort(arr);

          int ans = 0; // this will store cycle
          boolean[] visited = new boolean[n]; // visited array
          // start traversing 
          for(int i = 0; i < n; i++){
              // igf visited that means already sorted value
              // if both indexes are same that means it is already sorted so no need for any swapping
              if(visited[i] == true || arr[i].idx == i) continue;

              int cycle = 0; // this will calculate cycle
              int j = i; // start traversing from i
              while(visited[j] == false){
                  visited[j] = true;
                  cycle++;
                  j = arr[j].idx; // now set j at the idx of arr[j]
              }
              ans += cycle - 1;
              // after first swapping add cycle - 1 into ans becoz to swap 3 values only 2 cycles 
              // required
          }
          return ans;
      }
    
      private static class Pair implements Comparable<Pair> {
        int val;
        int idx;
    
        Pair(int val, int idx) {
          this.val = val;
          this.idx = idx;
        }
    
        @Override
        public int compareTo(Pair o) {
          return this.val - o.val;
        }
      }
}
