class Solution {
    public int numSquares(int n) {
        if(n<=1) return n;
        
        int[] tmp = new int[n+1];
        List<Integer> squares = new ArrayList<>();
        tmp[0] = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=n;i++){
            if(isSquare(i)){
                tmp[i] = 1;
                squares.add(i);
                continue;
            }
            for(Integer square : squares){
                min = tmp[i-square]+1<min? tmp[i-square]+1:min;
            }
            tmp[i] = min;
            min = Integer.MAX_VALUE;
        }
        return tmp[n];
    }
    
    public boolean isSquare(int n){
        double root = Math.sqrt(n);
        return root-Math.floor(root) == 0;
    }
}

// using a direct for loop without square list, improve time complexity by 30%

class Solution {
    public int numSquares(int n) {
        if(n<=1) return n;
        
        int[] tmp = new int[n+1];
        tmp[0] = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=n;i++){
            if(isSquare(i)){
                tmp[i] = 1;
                continue;
            }
            for(int r = 1; r <= Math.sqrt(i);r++){
                min = tmp[i-r*r]+1<min? tmp[i-r*r]+1:min;
            }
            tmp[i] = min;
            min = Integer.MAX_VALUE;
        }
        return tmp[n];
    }
    
    public boolean isSquare(int n){
        double root = Math.sqrt(n);
        return root-Math.floor(root) == 0;
    }
}