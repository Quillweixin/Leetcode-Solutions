class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return res;
        helper(root,0);
        return res;
    }
    
    private void helper(TreeNode node,int level){
        if(level >= res.size()){
            List<Integer> lst = new ArrayList<>();
            res.add(0,lst);
        }
        if(node.left != null) helper(node.left,level+1);
        if(node.right != null) helper(node.right,level+1);
        res.get(res.size()-1-level).add(node.val);
    }
}