class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<Integer>(),1,1,n,k);
        return res;
    }
    
    public void dfs(List<List<Integer>> res,List<Integer> tmp,int depth,int num,int n,int k){
        if(depth>k) res.add(new ArrayList(tmp));
        else{
            for(int i = num;i<=n;i++){
                tmp.add(i);
                dfs(res,tmp,depth+1,i+1,n,k);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}