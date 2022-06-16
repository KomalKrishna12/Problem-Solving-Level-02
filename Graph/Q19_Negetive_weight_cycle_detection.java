import java.io.*;
public class Q19_Negetive_weight_cycle_detection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
    
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        int[][] arr = new int[m][3];
    
        for (int i = 0; i < m; i++) {
          st = br.readLine().split(" ");
          arr[i][0] = Integer.parseInt(st[0]);
          arr[i][1] = Integer.parseInt(st[1]);
          arr[i][2] = Integer.parseInt(st[2]);
        }
        
        System.out.println(isNegetiveCyclePresent(n, arr));
	}
	public static int isNegetiveCyclePresent(int n, int[][] arr){
	    int[] path = new int[n];
	    path[0] = 0;
	    
	    for(int i = 0; i < n - 1; i++){
	        for(int j = 0; j < arr.length; j++){
	            int u = arr[j][0];
	            int v = arr[j][1];
	            int wt = arr[j][2];
	            
	            if(path[u] == Integer.MAX_VALUE){
	                continue;
	            }
	            
	            if(path[u] + wt < path[v]){
	                path[v] = path[u] + wt;
	            }
	        }
	    }
	    
	    for(int j = 0; j < arr.length; j++){
	            int u = arr[j][0];
	            int v = arr[j][1];
	            int wt = arr[j][2];
	            
	            if(path[u] == Integer.MAX_VALUE){
	                continue;
	            }
	            
	            if(path[u] + wt < path[v]){
	                return 1;
	            }
	        }
	        return 0;
	}
}
