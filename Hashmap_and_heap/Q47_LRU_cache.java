import java.util.*;
import java.io.*;
public class Q47_LRU_cache {
    public static class LRU {
        class Node{
            int key, value;
            Node next, prev;
        }
        public void addNode(Node node){
            Node nbr = head.next; // nabor of head
            node.next = nbr;
            nbr.prev = node;
            head.next = node;
            node.prev = head;
        }
        public void removeNode(Node node){
            Node prevNbr = node.prev;
            Node nxtNbr = node.next;
            prevNbr.next = nxtNbr;
            nxtNbr.prev = prevNbr;
            node.next = node.prev = null;
        }
        public void moveToFirst(Node node){
            removeNode(node);
            addNode(node);
        }
        HashMap<Integer, Node> map;
        Node head, tail;
        int cap;
        LRU(int capacity) {
            cap = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
    
        public int get(int key) {
            Node node = map.get(key);
            if(node == null) return -1;
            else{
                int val = node.value;
                moveToFirst(node);
                return val;
            }
        }
    
        public void put(int key, int value) {
            Node node = map.get(key);
            if(node == null){
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                if(map.size() == cap){
                    Node LRU_node = tail.prev;
                    map.remove(LRU_node.key);
                    removeNode(LRU_node);
                }
                map.put(key, newNode);
                addNode(newNode);
            }
            else{
                node.value = value;
                moveToFirst(node);
            }
        }
      }
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));
    
        while (true) {
          str = br.readLine();
          String inp[] = str.split(" ");
          if (inp.length == 1) {
            break;
          } else if (inp.length == 2) {
            System.out.println(obj.get(Integer.parseInt(inp[1])));
          } else if (inp.length == 3) {
            obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
          }
        }
      }
}
