class Solution {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        findLeaf(root,0);
        return min;
    }
    
    private void findLeaf(TreeNode node,int curlevel){
        if(node==null) return;
        curlevel++;
        if(node.left==null && node.right==null){
            if(curlevel<min) min = curlevel;
            return;
        }
        findLeaf(node.left,curlevel);
        findLeaf(node.right,curlevel);
    }
}