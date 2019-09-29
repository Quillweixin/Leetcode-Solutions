class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<Integer>(),0,nums,res);
        return res;
    }
    
    public void dfs(List<Integer> tmp,int pos,int[] nums,List<List<Integer>> res){
        res.add(new ArrayList(tmp));

        for(int i=pos; i<nums.length;i++){
            // avoid duplicate! 
            if(i>pos && nums[i]==nums[i-1]) continue;
            tmp.add(nums[i]);
            dfs(tmp,i+1,nums,res);
            tmp.remove(tmp.size()-1);
        }
    }
}