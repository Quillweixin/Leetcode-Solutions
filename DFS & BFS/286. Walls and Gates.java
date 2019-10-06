class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[]{1,0},
        new int[]{-1,0},
        new int[]{0,1},
        new int[]{0,-1}
    );
    private static final int INF = Integer.MAX_VALUE;
    
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0;row<rooms.length;row++){
            for(int col = 0;col<rooms[0].length;col++){
                if(rooms[row][col]==0) queue.add(new int[]{row,col});
            }
        }
        while(queue.size()!=0){
            int[] pos = queue.poll();
            for(int[] direct: DIRECTIONS){
                int row = pos[0]+direct[0];
                int col = pos[1]+direct[1];
                if(row>=rooms.length || col>=rooms[0].length || row<0 || col<0 || rooms[row][col] != INF) continue;
                rooms[row][col] = rooms[pos[0]][pos[1]]+1;
                queue.add(new int[]{row,col});
            }
            
        }
    }
}