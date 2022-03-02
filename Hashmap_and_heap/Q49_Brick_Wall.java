import java.util.*;
// in this question we have given list of list which denotes a wall with some splits
// mark cut through any column so we crach min brick
// min brick = max split
// so create prefix sum
public class Q49_Brick_Wall {
    public static int leastBricks(List<List<Integer>> wall) {
        // create a hashmap map
        // for prefix sum
        // add val into ps and get their occrence
        // create a max varaibel and compare max split also
        // at end calculate min brick crach using subtracting max split from wall size
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(List<Integer> list : wall){
            int ps = 0;
            for(int i = 0; i < list.size()-1; i++){
                int val = list.get(i);
                ps += val;
                map.put(ps, map.getOrDefault(ps, 0) + 1);
                max = Math.max(max, map.get(ps));
            }
        }
        return wall.size() - max;
    }
    
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      List<List<Integer>> wall = new ArrayList<>();
      List<Integer> col = new ArrayList<>();
      for(int i = 0; i < n; i++){
          int m = scn.nextInt();
          for(int j = 0; j < m; j++){
              col.add(j, scn.nextInt());
          }
         wall.add(i, col); 
      }
      scn.close();
      System.out.println(leastBricks(wall));
  }
}
