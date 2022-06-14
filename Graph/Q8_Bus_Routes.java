import java.io.*;
import java.util.*;
// given an array and S and T
// in an array row denotes bus no and it's array denotes bustops
// we have to check in how many buses changing we can reach destination
public class Q8_Bus_Routes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          String[] st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));
    
      }
    
      public static int numBusesToDestination(int[][] routes, int S, int T) {
    // store all bustops as key and busses as value
    // row is our busses and the array of row is the busstop
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < routes.length; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        int bustop = routes[i][j];
        ArrayList<Integer> busno = map.getOrDefault(bustop, new ArrayList<>());
        busno.add(i);
        // i is the row so add bus i into routes[i][j] bustop
        map.put(bustop, busno);
      }
    }

    // create two hashset one for busno and one for bustop
    // both will be used to check that the bus or bustop is visited or not
    // create a queue and add source s bustop

    HashSet<Integer> busVisit = new HashSet<>();
    HashSet<Integer> bustopVisit = new HashSet<>();
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(S);
    bustopVisit.add(S);
    int level = 0;

    while (queue.size() > 0) {

      int size = queue.size();

      while (size-- > 0) {

        int rem = queue.removeFirst();

        if (rem == T) return level; // if we reached destination then remove the level

        ArrayList<Integer> buses = map.get(rem);

        for (int bus : buses) {
          if (busVisit.contains(bus) == true) continue;

          int[] arr = routes[bus]; // this will give array of bus no

          // now run a loop on this bus no and check all bustop in this bus
          // if they are visited then continue else add it into visited and add it into the queue
          for (int bb : arr) {
            if (bustopVisit.contains(bb) == true) continue;

            queue.add(bb);
            bustopVisit.add(bb);
          }
          busVisit.add(bus);
        }
      }
      level++;
    }
    return -1;

      }
}
