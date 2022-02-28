import java.util.*;
// in this ques we have given n (total no of works), m(completed works by 3 workers) and arr(all works
// which is completed by worker)
// we have total 5 workers, in which three workers completed m works and left
// now we have 2 workers left they've to complete rest work (n - m) 
// and they have to work in sequence like first will do first work then second then again first and second
public class Q40_Task_completion {
    public static void completeTask(int n, int m, int[] arr) {
        // create a hashset and add all completed task from arraya
        // create a boolena var flag if it is true then add work in one worker else add in two
        // now travrse from 1 to n, check that work is completd or not
        // if not compplted then check flag and add
        // at end show one and two workers work
		HashSet<Integer> completed = new HashSet<>();
        for(int val : arr) completed.add(val);

        boolean flag = true;
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(completed.contains(i) == false){
                if(flag) one.add(i);
                else two.add(i);
                flag = !flag;
            }
        }

        for(int val : one){
            System.out.print(val + " ");
        }
        System.out.println();

        for(int val : two){
            System.out.print(val + " ");
        }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
        scn.close();
		completeTask(n, m, num);
	}
}
