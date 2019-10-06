class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList,1);
        }
    public int helper(List<NestedInteger> lst,int depth){
        if(lst.size()==0) return 0;
        int res = 0;
        for(NestedInteger nested: lst){
            if(nested.isInteger()) res += nested.getInteger()*depth;
            res += helper(nested.getList(),depth+1);
        }
        return res;
    }
}