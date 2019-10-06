class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = findDepth(nestedList,1);
        int res = helper(nestedList,depth);
        return res;
    }
    public int findDepth(List<NestedInteger> lst, int depth){
        int res = depth;
        for(NestedInteger element: lst){
            if(!element.isInteger()) res = Math.max(findDepth(element.getList(),depth+1),res);
        }
        return res;
    }
    public int helper(List<NestedInteger> lst,int weight){
        if(lst==null) return 0;
        int res = 0;
        for(NestedInteger element:lst){
            if(element.isInteger()) {
                res+=element.getInteger()*weight;
            }
            else res += helper(element.getList(),weight-1);
        }
        return res;
    }
}