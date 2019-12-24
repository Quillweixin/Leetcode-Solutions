class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        helper(root,"",root);
        return res;
    }
    
    private void helper(TreeNode node,String str,TreeNode root){
        StringBuilder sb = new StringBuilder(str);
        if(node!=root){
            sb.append("->");
        }
        sb.append(node.val);
        String s = sb.toString();
        if(node.left==null && node.right==null){
            if(!res.contains(s)) res.add(s);
            return;
        }
        if(node.left!=null) helper(node.left,s,root);
        if(node.right!=null) helper(node.right,s,root);
    }
}