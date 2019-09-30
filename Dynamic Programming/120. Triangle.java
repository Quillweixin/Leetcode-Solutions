class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> totals = new ArrayList<>();
        for(int row = 0; row < triangle.size();row++){
            if(row==0){
                totals.add(triangle.get(0));
                continue;
            }else{
                List<Integer> toAdd = new ArrayList<>();
                for(int col = 0;col<triangle.get(row).size();col++){
                    int num = triangle.get(row).get(col);
                    int subtotal = findMin(totals.get(row-1),col-1,col)+num;
                    toAdd.add(subtotal);
                }
                totals.add(toAdd);
            }
        }
        
        return findMin(totals.get(totals.size()-1),0,totals.get(totals.size()-1).size()-1);
    }
    
    public int findMin(List<Integer> lst,int start,int end){
        int min = Integer.MAX_VALUE;
        if(start<0) start = 0;
        if(end>=lst.size()) end=lst.size()-1;
        for(int i = start;i<=end;i++){if(lst.get(i)<min) min = lst.get(i);}
        return min;
    }

}

// use array instead of arraylist can improve the time complexity a little bit

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] totals = new int[size][size];
        for(int[] arr : totals) Arrays.fill(arr,Integer.MIN_VALUE);
        for(int row = 0; row < size;row++){
            if(row==0){
                totals[0][0] = triangle.get(0).get(0);
                continue;
            }
            for(int col = 0;col<triangle.get(row).size();col++){
                int num = triangle.get(row).get(col);
                int a = totals[row-1][col];
                if(col==0) {
                    totals[row][col] = a+num;
                    continue;
                }
                int b = totals[row-1][col-1];
                if(a==Integer.MIN_VALUE){
                    totals[row][col] = b+num;
                    continue;
                }
                totals[row][col] = Math.min(a,b)+num;
            }
        }
        
        // find the minimal sum in the last row;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<size;i++){
            min = Math.min(min,totals[size-1][i]);
        }
        return min;
    }
}