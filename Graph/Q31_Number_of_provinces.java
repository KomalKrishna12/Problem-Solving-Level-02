public class Q31_Number_of_provinces {
    public static int findCircleNum(int[][] graph) {
        int ans = 0;
        for(int i = 0; i < graph.length; i++){
            if(graph[i][i] == 0) continue;
            ans++;
            dfs(graph, i);
        }
        return ans;
    }

    public static void dfs(int[][] graph, int i){
        graph[i][i] = 0;
        for(int j = 0; j < graph.length; j++){
            if(graph[i][j] == 1){
                graph[i][j] = 0;
                if(graph[j][j] == 1){
                    dfs(graph, j);
                } 
            }
        }
    } 

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }  
}  
// git add .  
// git commit -m "."
// git push
 