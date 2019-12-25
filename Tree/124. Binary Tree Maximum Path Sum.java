class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return max;
        subtreeSumMax(root);
        return max;
    }
    
    private int subtreeSumMax(TreeNode node){
        if(node==null) return 0;
        // do not add up the sum of the subtree if it is negative
        int left = Math.max(subtreeSumMax(node.left),0);
        int right = Math.max(subtreeSumMax(node.right),0);
        int sum = node.val + left + right;
        if(sum>max) max = sum;
        return node.val+Math.max(left,right);
    }
}