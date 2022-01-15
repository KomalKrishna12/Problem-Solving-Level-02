import java.util.*;

public class Q11_unique_BST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static Scanner scn = new Scanner(System.in);

    // if n = 1 then we're required to add all the unique BST's which can be made up of n nodes
    // if n is 1 then only 1 BST can be constructed
    // if n is 2 then 2 
    // for n = 3 craete a loop so here we can create node as 1 or 2 or 3
    // if root is 1 then we have left 2 and 3 as nodes and for 2 we can create 2 unique BST
    // same with root 3 and nodes 1 and 2 and if root is 2 then in left we have 1 node and on right we  have
    // one 1 node right so total node will be 2(root 1, 2 & 3 node) + 1(root 2, 1 left, 3 right) + 2(root 3, 1 & 2 node)
    public List<TreeNode> generateTrees(int n) {
        return generateTrees_(1, n);
    }
    public List<TreeNode> generateTrees_(int s, int e) {
        if(s > e){
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }
        
        List<TreeNode> ans = new ArrayList<>();    
        for(int i = s; i <= e; i++){
            List<TreeNode> l = generateTrees_(s, i - 1);
            List<TreeNode> r = generateTrees_(i + 1, e);
            for(TreeNode left : l){
                for(TreeNode right : r){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}