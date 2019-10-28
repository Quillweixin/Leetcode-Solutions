class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        if(numRows == 1) return res;
        
        for(int row = 1; row<numRows;row++){
            List<Integer> toAdd = new ArrayList<>();
            for(int index = 0; index < row+1;index++){
                if(index == 0 || index == res.get(row-1).size()){
                    toAdd.add(1);
                }else{
                    toAdd.add(res.get(row-1).get(index)+res.get(row-1).get(index-1));
                }
            }
            res.add(toAdd);
        }
        return res;
        
    }
}