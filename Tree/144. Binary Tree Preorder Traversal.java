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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        traverse(root,res);
        return res;
    }
    public void traverse(TreeNode node,List<Integer> res){
        res.add(node.val);
        if(node.left != null) traverse(node.left,res);
        if(node.right != null) traverse(node.right,res);
        
    }
}