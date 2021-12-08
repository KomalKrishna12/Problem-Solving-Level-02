import java.io.*;
import java.util.LinkedList;
//here we have given a linked list and we want to achieve functionality of queue
//in queue we FIFO structure
//so we can add using addLast(val)
//remove using removeLast()
//and peek using getFirst()
public class Q12_Linked_List_To_Queue_Adapter {
    public static class LLToQueueAdapter {
        LinkedList<Integer> list;
    
        public LLToQueueAdapter() {
          list = new LinkedList<>();
        }
    
        int size() {
            return list.size();
        }
    
        void add(int val) {
            list.addLast(val);
        }
    
        int remove() {
            if(size() == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                return list.removeFirst();
            }
        }
    
        int peek() {
            if(size() == 0){
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                return list.getFirst();
            }
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToQueueAdapter qu = new LLToQueueAdapter();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("add")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if (str.startsWith("remove")) {
            int val = qu.remove();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("peek")) {
            int val = qu.peek();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(qu.size());
          }
          str = br.readLine();
        }
      }
}
