class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return helper(root1,root2);
    }
    
    private boolean helper(TreeNode n1, TreeNode n2){
        if(n1==null && n2==null) return true;
        if((n1==null && n2!=null) || (n1!=null && n2==null)) return false;
        if(n1.val != n2.val) return false;
        
        boolean noFlip = helper(n1.left,n2.left) && helper(n1.right,n2.right);
        if(noFlip) return true;
        return helper(n1.left,n2.right) && helper(n1.right,n2.left);
    }
}
