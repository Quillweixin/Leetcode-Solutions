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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if((root.left==null && root.right!=null)||(root.left!=null && root.right==null))
            return false;
        // recursively check the sub trees.
        return checkSubtree(root.left,root.right);
    }
    
    public boolean checkSubtree(TreeNode node1, TreeNode node2){
        if(node1.val != node2.val) return false;
        if(node1.left==null&&node2.left==null&&node1.right==null&&node2.right==null) 
            return true;
        
        if((node1.left==null && node2.right!=null)||
           (node1.left!=null&&node2.right==null))
            return false;
        if((node1.right==null && node2.left!=null)||
            (node1.right!=null&&node2.left==null))
            return false;
        
        // check subtrees of their childrens
        boolean b1 = node1.left!=null && node2.right!=null ?
            checkSubtree(node1.left,node2.right) : true;
        boolean b2 = node1.right!=null && node2.left!=null ?
            checkSubtree(node1.right,node2.left) : true;
        
        return b1 && b2;
    }
}

// more elagant way using recursion-----------

public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
}