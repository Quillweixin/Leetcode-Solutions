class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null && sum!=0) return res;
        List<Integer> lst = new ArrayList<>();
        helper(root,sum,lst);
        return res;
    }
    
    private void helper(TreeNode node,int target,List<Integer> l){
        if(node==null) return;
        // create a copy of the list.
        List<Integer> lst = new ArrayList(l);
        target -= node.val;
        lst.add(node.val);
        if(target == 0 && node.left==null && node.right==null){
            res.add(lst);
            return;
        }
        helper(node.left,target,lst);
        helper(node.right,target,lst);
    }
}

// improvement without creating duplicate lists

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null && sum!=0) return res;
        List<Integer> lst = new ArrayList<>();
        helper(root,sum,lst);
        return res;
    }
    
    private void helper(TreeNode node,int target,List<Integer> lst){
        if(node==null) return;
        target -= node.val;
        lst.add(node.val);
        if(node.left==null && node.right==null){
            if(target==0) res.add(new ArrayList(lst));
            lst.remove(lst.size()-1);
            return;
        }
        helper(node.left,target,lst);
        helper(node.right,target,lst);
        lst.remove(lst.size()-1); //** remove the last element we added (similar to backtracking)
    }
}