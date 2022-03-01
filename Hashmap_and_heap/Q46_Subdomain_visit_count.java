import java.util.*;
// input = ["9001 discuss.leetcode.com"]
// Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
// in this question we have given sum domains in array we are required to find out all possible subdomains
// string str = "9001 discuss.leetcode.com" means "discuss.leetcode.com" is available 9001 times
// visit leetcode 811 to read the question
public class Q46_Subdomain_visit_count {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        //  firstly create a for loop on cpdomains so we get a single domain every time loop executes
        // now split the string with space " " so it'll split count and domains
        // now store count into visitcount
        // now split domain with ".", to split base on "." use "\\."
        // now we have words in domain
        // now create a for loop on words from end
        // if i is the last index then append words[i] into string buidler object sb
        // else append a "." in 0th index
        // then append words[i] at 0th index
        // now conver sb into string and check the map
        // if string is in map then increase it's count by visitcount else put it with visitcount
        // after this loop create an arraylist and add value then space then string and ad it into list
		for(String domain : cpdomains){
            String[] afterSplit = domain.split(" ");
            int visitCount = Integer.parseInt(afterSplit[0]);
            String[] words = afterSplit[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for(int i = words.length - 1; i >= 0; i--){
                if(i == words.length - 1){
                    sb.append(words[i]);
                }
                else{
                    sb.insert(0, ".");
                    sb.insert(0, words[i]);
                }
                String subDomain = sb.toString();
                map.put(subDomain, map.getOrDefault(subDomain, 0) + visitCount);
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        for(String domain : map.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(domain));
            sb.append(" ");
            sb.append(domain);
            ans.add(sb.toString());
        }

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] cpd = new String[n];
		for (int i = 0; i < cpd.length; i++) {
			cpd[i] = s.nextLine();
		}
        s.close();
		List<String> ans = subdomainVisits(cpd);
		Collections.sort(ans);
		System.out.println(ans);
	}
}
