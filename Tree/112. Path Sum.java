class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null && sum != 0) return false;
        return helper(root,sum,0);
    }
    
    private boolean helper(TreeNode node,int target,int sum){
        if(node==null) return false;
        sum += node.val;
        if(node.left==null && node.right==null){
            return sum==target;
        }
        return helper(node.left,target,sum) || helper(node.right,target,sum);
    }
}