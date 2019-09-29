class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        trySum(candidates,target,res,new ArrayList<Integer>());
        return res;
    }
    
    public void trySum(int[] candidates,int target,List<List<Integer>> res,List<Integer> tmp){
        if(target<0) return;
        if(target==0){  //avoid duplicates!
            List<Integer> toAdd = new ArrayList(tmp);
            Collections.sort(toAdd);
            for(List<Integer> lst : res){
                if(lst.equals(toAdd)) return;
            }
            res.add(toAdd);
            return;
        }
        for(int i = 0;i<candidates.length;i++){
            tmp.add(candidates[i]);
            trySum(candidates,target-candidates[i],res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    
}

// better way to check duplicates---------------

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        trySum(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }
    
    public void trySum(int[] candidates,int target,List<List<Integer>> res,List<Integer> tmp,int pos){
        if(target<0) return;
        if(target==0){  
            List<Integer> toAdd = new ArrayList(tmp);
            res.add(toAdd);
            return;
        }
        for(int i = pos;i<candidates.length;i++){
            tmp.add(candidates[i]);
            // -----use pos and sorted array to avoid duplicate.-----
            trySum(candidates,target-candidates[i],res,tmp,i);
            tmp.remove(tmp.size()-1);
        }
    }
    
}
