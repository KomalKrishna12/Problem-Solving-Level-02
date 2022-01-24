import java.util.*;

public class Number_of_emp_under_every_manager {
    public static void findcount(HashMap<String, String> map) {
        HashMap<String, HashSet<String>> tree = new HashMap<>();

        String ceo = "";
        //ceo is the person whose manager is the same person like m is manager of m so m is the ceo

        for(String emp : map.keySet()){
            String man = map.get(emp);

            if(man.equals(emp)){
                ceo = man;
            }
            else{
                if(tree.containsKey(man)){
                    HashSet<String> emps = tree.get(man);
                    emps.add(emp);
                }
                else{
                    HashSet<String> emps = new HashSet<>();
                    emps.add(emp);
                    tree.put(man, emps);
                }
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);
        for(String emp : result.keySet()){
            System.out.println(emp + " " + result.get(emp));
        }
    }

    public static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> result){
        int size = 0;
        if(tree.containsKey(man) == false){
            result.put(man, 0);
            return 1;
        }
        for(String emp : tree.get(man)){
            int cs = getSize(tree, emp, result);
            size += cs;
        }
        result.put(man, size);
        return size + 1;
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