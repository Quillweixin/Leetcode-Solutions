/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // improve performance
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return res;
        traverse(root,0);
        return res;
    }
    public void traverse(TreeNode node, int level){
        // create a list for current level
        if(level > res.size()-1){
            List<Integer> lst = new ArrayList<>();
            res.add(lst);
        }
        res.get(level).add(node.val);
        if(node.left != null) traverse(node.left,level+1);
        if(node.right != null) traverse(node.right,level+1);
    }
}