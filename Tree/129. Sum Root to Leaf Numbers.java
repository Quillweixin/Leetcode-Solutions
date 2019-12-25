class Solution {
    int total = 0;
    
    public int sumNumbers(TreeNode root) {
        if (root == null) return total;
        pathSum(root,0);
        return total;
    }
    
    private void pathSum(TreeNode node,int sum){
        sum = sum*10+node.val;
        if(node.left==null && node.right==null){
            // System.out.println(sum);
            total+=sum;
            return;
        }
        if(node.left!=null) pathSum(node.left,sum);
        if(node.right != null) pathSum(node.right,sum);
    }
}