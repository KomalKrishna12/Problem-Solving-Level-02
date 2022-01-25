import java.util.*;

public class Number_of_emp_under_every_manager {
    public static void findcount(HashMap<String, String> map) {
        HashMap<String, HashSet<String>> tree = new HashMap<>();

        String ceo = "";
        //ceo is the person whose manager is the same person like m is manager of m so m is the ceo

        // so we are creating a loop into map and storing manager into man if man and emp is same
        // then store it into ceo
        // else check if the man is in the tree or not
        // if true then add one more emp to hashset
        // else create a hashset and add emp into that and put it into tree hashmap 
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

        // now create a hashmap result and store manager with it's no of emp
        HashMap<String, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);
        for(String emp : result.keySet()){
            System.out.println(emp + " " + result.get(emp));
        }
    }

    // now it's a generic tree and we want to calculate size of tree
    // create a size variable initialize it with 0
    // now if tree doesn't contains manager then put 0 in no of emp and return 1 (base case)
    // now create a for each loop for calculating size for every children
    // add that children size(cs) into size
    // after loop ended add it into result hashmap and return size + 1
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