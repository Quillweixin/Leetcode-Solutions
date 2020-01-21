class Solution {
    // dfs from every node as the top to find the longest path.
    // the longest path of that node is the sum of the depth of left subtree and right subtree.
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return max;
        if(root.left==null && root.right==null) return max;
        dfs(root);
        return max;
    }
    private void dfs(TreeNode node){
        if(node==null) return;
        
        int left = helper(node.left,0);
        int right = helper(node.right,0);
        int path = left+right;
        max = Math.max(path,max);
        dfs(node.left);
        dfs(node.right);
    }
    private int helper(TreeNode node, int level){
        if(node==null) return level;
        int left = helper(node.left,level+1);
        int right = helper(node.right,level+1);
        return Math.max(left,right);
    }
}

// performance improved 
class Solution{
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}