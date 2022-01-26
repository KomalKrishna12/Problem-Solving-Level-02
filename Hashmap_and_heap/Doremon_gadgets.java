import java.util.*;
public class Doremon_gadgets{
    public static ArrayList<Integer> TopK(ArrayList<Integer> array, int k)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        //HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < array.size(); i++){
            
        }

        return ans;
    }
    public static void main(String[] args) {
        // {1, 1, 1, 2, 2, 3}
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        ArrayList<Integer> ans = TopK(list, 2);
        System.out.println(ans);
    }
}