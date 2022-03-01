import java.util.*;
import java.io.*;
// LRU (least recent used)
// ex : cap = 3
// put 1 10 -- add this
// put 2 20 -- add this
// put 3 30 -- add this
// get 1    -- show this value and make it in recent used 
// put 1 15 -- update its value and make it in recent used
// get 1    -- show this value and make it in recent used 
// get 2    -- show this value and make it in recent used 
// put 4 40 -- cap is already 3 so remove least used and add this
// get 3    -- show this value and make it in recent used 
// get 4    -- show this value and make it in recent used 
// Stop
public class Q47_LRU_cache {
    public static class LRU {
        // create a node class for linked list bcoz using linked list we can add in first
        // remove last and get any node
        // use doubly linked list bcoz in this we can easly traverse through the list using next and prev
        // key will be 1 is(1-10), 10 will be value
        class Node{
            int key, value;
            Node next, prev;
        }
        // we have two node head and prev
        // craete a nbr node which will store next of head
        // now next of node will point to nbr
        // nbr prev point to node
        // head next point to node 
        // node prev point to head
        public void addNode(Node node){
            Node nbr = head.next; // nabor of head
            node.next = nbr;
            nbr.prev = node;
            head.next = node;
            node.prev = head;
        }
        // to remove craete two node one is prevnbr and another is nextnbr
        // prevnbr will store prev of node and nextnbr will store next of node
        // now next of prevnbr point to nextnbr and nextnbr prev point to prevnbr
        // and next and prev of node poin to null
        public void removeNode(Node node){
            Node prevNbr = node.prev;
            Node nxtNbr = node.next;
            prevNbr.next = nxtNbr;
            nxtNbr.prev = prevNbr;
            node.next = node.prev = null;
        }
        // remove that node and add in the first
        public void moveToFirst(Node node){
            removeNode(node);
            addNode(node);
        }
        HashMap<Integer, Node> map;
        Node head, tail;
        int cap; // if cap reached then remove least used node and add the new node into recent
        LRU(int capacity) {
            cap = capacity;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
    
        // create a node and get from the map for the key
        // if node is null that means that key node is not exist so return -1
        // else move the node to recent used and return value for that key
        public int get(int key) {
            Node node = map.get(key);
            if(node == null) return -1;
            else{
                int val = node.value;
                moveToFirst(node);
                return val;
            }
        }
    
        // for put check wheather node for the key value exists or not
        // if node null that means not exists
        // so create newnode, set its key and value
        // now check the cap
        // if cap reached then remove last node using tail.prev
        // now put new node 
        // if node already exists then update its value and move to recent used
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
