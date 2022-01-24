import java.util.*;

public class Number_of_emp_under_every_manager {
    public static void findcount(HashMap<String, String> map) {
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // write your code here

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(scn.next(), scn.next());
        }
        scn.close();
        findcount(map);
    }
}