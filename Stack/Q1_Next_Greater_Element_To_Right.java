import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1_Next_Greater_Element_To_Right{
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
          // ngr(next greater to right) is an array of same length as arr
          // in ngr we store the next greater right element for each element of arr in that particular posiiton
          // start from end
          // for end ngr will be -1 becoz there is no greater element for end index
          // create a stack and puch last element
          // create a for loop it'll run till arr.length-2 to 0 for storing rest index of ngr array
          // firstly check that the stack is not empty and stack peek is less than or equal to arr[i]
          // then pop that element till size become 0 or we get the greater element
          // if size become zero that means in right side there is no greater element for arr[i] so set -1
          // if size is not zero then store peek() of stack in ngr for that particular index
          int[] ngr = new int[arr.length];
          Stack<Integer> stack = new Stack<>();
          stack.push(arr[arr.length - 1]);
          ngr[arr.length - 1] = -1;
          for (int i = arr.length - 2; i >= 0; i--) {
              while(stack.size() > 0 && stack.peek() <= arr[i]){
                  stack.pop();
              }
              if(stack.empty()) ngr[i] = -1;
              else ngr[i] = stack.peek();
              stack.push(arr[i]);
          }
          return ngr;
      }
}