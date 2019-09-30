class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }
    
    public void dfs(int[]candidates, int target, List<List<Integer>> res,List<Integer> tmp,int pos){
        if(target<0) return;
        if(target == 0){
            res.add(new ArrayList(tmp));
            return;
        }
        for(int i = pos;i < candidates.length;i++){
            // avoid duplicate!
            if(i>pos&&candidates[i]==candidates[i-1]) continue;
            tmp.add(candidates[i]);
            dfs(candidates,target-candidates[i],res,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}