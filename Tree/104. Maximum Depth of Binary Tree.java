class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return max;
    }
    
    private void helper(TreeNode node,int level){
        if(node==null) return;
        level++;
        if(node.left==null && node.right==null){
            max = Math.max(max,level);
            return;
        }
        helper(node.left,level);
        helper(node.right,level);
    }
}