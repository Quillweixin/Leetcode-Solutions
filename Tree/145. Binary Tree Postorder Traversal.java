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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode node, List<Integer> res){
        if(node.left != null) postorder(node.left,res);
        if(node.right != null) postorder(node.right,res);
        res.add(node.val);
    }
}