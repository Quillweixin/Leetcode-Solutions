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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode node, List<Integer> res){
        if(node.left != null) preorder(node.left,res);
        res.add(node.val);
        if(node.right != null) preorder(node.right,res);
    }
}
