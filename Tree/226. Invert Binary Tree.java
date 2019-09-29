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
    public TreeNode invertTree(TreeNode root) {
        // swap the left and right child in every level
        swap(root);
        return root;
    }
    public void swap(TreeNode node){
        if(node==null) return;
        if(node.left == null && node.right ==null) return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        // swap to children
        node.left = right;
        node.right = left;
        // recursively swap their children
        swap(node.left);
        swap(node.right);
    }
}