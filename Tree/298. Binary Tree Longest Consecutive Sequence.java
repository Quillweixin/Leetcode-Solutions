class Solution {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        longestConsequence(root.left,1,root.val);
        longestConsequence(root.right,1,root.val);
        return max;
    }
    
    private void longestConsequence(TreeNode node,int curlen,int cur){
        if(node==null) return;
        curlen = cur+1==node.val? curlen+1:1;
        if(curlen>max) max = curlen;
        longestConsequence(node.left,curlen,node.val);
        longestConsequence(node.right,curlen,node.val);
    }
}