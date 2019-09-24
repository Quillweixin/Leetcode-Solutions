public class Solution extends Relation {
    public int findCelebrity(int n) {
        // brutal force
        int res = -1;
        for(int i = 0; i < n; i++){
            int j = 0;
            for(; j < n;j++){
                if(i==j) continue;
                if(knows(i,j) || !knows(j,i)) break;
            }
            if(j==n) res = i;
        }
        return res;
    }
}

// -----better solution-------

// The first pass is to pick out the candidate. 
// If candidate knows i, then switch candidate. 
// The second pass is to check whether the candidate is real.
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}