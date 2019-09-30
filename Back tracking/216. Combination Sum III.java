class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=0 || n> 45) return res;
        dfs(k,n,res,new ArrayList<Integer>(),1);
        return res;
    }
    
    public void dfs(int k,int n,List<List<Integer>> res,List<Integer> tmp,int pos){
        if(n<0) return;
        if(k == 0){
            if(n==0){ //catch one solution
                res.add(new ArrayList(tmp));
                return;
            }
            return;
        }
        for(int i = pos;i<10;i++){
            tmp.add(i);
            dfs(k-1,n-i,res,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}