import java.util.*;
// we have given a string which contains opening and closing brackets
// we have two functions
// one is to check how min paranthesis we have to remove to make the string valid
// second is to print that valid string which is havig min removal which is calculated from getMin() 
public class Q17_Remove_invalid_paranthesis {
    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if (minRemoval == 0) {
            int min = getMin(str); // if no extra char that means it is a valid string so check
            // that the string is already printed or not using hashset 
            if (min == 0) {
                if (ans.contains(str) == false) {
                    System.out.println(str);
                    ans.add(str);
                }
            }
            return;
        }

        // we want to remove ith char so in left store from 0 to i so it'll add till i-1th
        // in right store string from i+1 to end now pass left+right as string in the solution
        // ans decrease the minremoval by 1 bcoz we aleady removed one char in this step 
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solution(left + right, minRemoval - 1, ans);
        }
    }

    public static int getMin(String str) {
        // to check the min no of elements we use stack
        // if opening brakcet then add
        // if closing than check few conditions
        // if stack is empty then add it into stack
        // if stack top is '(' then pop that 
        // if stack top contains ')' already then add current one also
        // at end after loop return stack size that will be our total no of min paranthesis which
        // has to be removed to make the string valid
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0)
                    st.push(ch);
                else if (st.peek() == '(')
                    st.pop();
                else if (st.peek() == ')')
                    st.push(ch);
            }
        }

        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        solution(str, getMin(str), new HashSet<>());
    }
}
