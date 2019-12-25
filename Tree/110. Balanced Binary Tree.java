class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = height(root.left,0);
        int right = height(root.right,0);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    
    private int height(TreeNode node,int height){
        if(node==null) return height;
        int left = height(node.left,height+1);
        int right = height(node.right,height+1);
        return Math.max(left,right);
    }
}