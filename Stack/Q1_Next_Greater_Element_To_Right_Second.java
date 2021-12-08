import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1_Next_Greater_Element_To_Right_Second{
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
    
        for (int val : a) {
          sb.append(val + "\n");
        }
        System.out.println(sb);
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = Integer.parseInt(br.readLine());
        }
    
        int[] nge = solve(a);
        display(nge);
      }
    
      public static int[] solve(int[] arr) {
        // in this approach we are pushing index 
        // if value of that index is smaller than arr[i] than for them ngr will be arr[i] and then pop them
        // push all index
        // after loop if stack is not empty that means their is no greater elements for those indexes so
        // set -1 in ngr and pop them
          int[] ngr = new int[arr.length];
          Stack<Integer> stack = new Stack<>();
          stack.push(0);
          for (int i = 1; i < ngr.length; i++) {
            while(stack.size() > 0 && arr[i] > arr[stack.peek()]){
              int pos = stack.peek();
              ngr[pos] = arr[i];
              stack.pop();
            }
            stack.push(i);
          }
          while(stack.size() > 0){
            int pos = stack.peek();
            ngr[pos] = -1;
            stack.pop();
          }
          return ngr;
      }
}