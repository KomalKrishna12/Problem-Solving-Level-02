import java.util.*;
// in the question we have given three variable x, y and bound
// we are required to find out all the no for which x^i + y^j <= bound
// 1 <= x & y <= 100
public class Q44_Powerful_number {
	// create two array list one for storing power of x and another one for storing power of y
	// now add 1 in both the list, becoz power of any number with 0 is 1
	// now number becomer x and y with power as 1
	// check if x is not equal to 1 becoz if pow is 1 then it'll be an infinite loop
	// now check powX is less than bound, and add it into px and multiply x with powX
	// do this same with y
	// now create a hashset becoz in ans we don't want duplicate numbers
	// create a for loop for list px and inside it create for list py and calculate both val if their 
	// sum is less than or equal to bound then add it into set
	// now create a arraylist and add set into the list and retrun it
    public static ArrayList<Integer> powerfulIntegers(int x, int y, int bound) {
		ArrayList<Integer> px = new ArrayList<>();
		ArrayList<Integer> py = new ArrayList<>();
		px.add(1); //x^0 is 1
		py.add(1);
		int powX = x, powY = y;
		if(x != 1){
			while(powX < bound){
				px.add(powX);
				powX *= x;
			}
		}
		if(y != 1){
			while(powY < bound){
				py.add(powY);
				powY *= y;
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i : px){
			for(int j : py){
				if(i + j <= bound) set.add(i + j);
			}
		}
		return new ArrayList<>(set);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int y = scn.nextInt();
		int bound = scn.nextInt();
        scn.close();
		ArrayList<Integer> ret = new ArrayList<>();
		ret = powerfulIntegers(x, y, bound);
		Collections.sort(ret);
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(ret.get(i) + " ");
		}
	}
}
