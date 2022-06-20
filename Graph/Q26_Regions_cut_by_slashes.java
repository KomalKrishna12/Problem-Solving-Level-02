// here we work on dots
// if array size is n then dot will be n+1
// if char is "/" then (i, j+1) & (i+1, j)
// if "\\" then (i, j) & (i+1, j+1)
public class Q26_Regions_cut_by_slashes {
    public static void main(String[] args) {
        String[] grid = {" /","/ "};
        System.out.println(regionsBySlashes(grid));
    }
    public static int regionsBySlashes(String[] grid) {
        int dots = grid.length + 1;
        parent = new int[dots*dots];
        rank = new int[dots*dots];
        count = 1;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < dots; i++){
            for(int j = 0; j < dots; j++){
                if(i == 0 || j == 0 || i == dots - 1 || j == dots - 1){
                    int cellno = i * dots + j;
                    if(cellno != 0)
                    union(0, cellno);
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++){
            char[] ch = grid[i].toCharArray();
            for(int j = 0; j < ch.length; j++){
                if(ch[j] == '/'){
                    int cellno1 = (i) * dots + (j+1);
                    int cellno2 = (i+1) * dots + j;
                    union(cellno1, cellno2);
                }
                else if(ch[j] == '\\'){
                    int cellno1 = i * dots + j;
                    int cellno2 = (i+1) * dots + (j+1);
                    union(cellno1, cellno2);
                }
            }
        }
        
        return count;
    }
    
    static int[] parent;
    static int[] rank;
    static int count;
    
    public static int find(int x){
        if(x == parent[x]) return x;
        
        int temp = find(parent[x]);
        parent[x] = temp;
        
        return temp;
    }
    
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }
            else if(rank[ly] > rank[lx]){
                parent[lx] = ly;
            }
            else{
                parent[lx] = ly;
                rank[lx]++;
            }
        }
        else{
            // if leaders are same that means these two vertex has already a path
            // and we are ading another path so it makes a cycle so increase the count
            count++;
        }
    }
}
