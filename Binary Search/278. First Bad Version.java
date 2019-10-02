/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1,right = n;
        while(!(!isBadVersion(left)&&isBadVersion(right)&&left==right-1)){
            if(right == 1) return 1;
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)) right = mid;
            else left = mid;
        }
        return right;  
    }
}

// better solution that reduce the time cost of calling API

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
       if(n <= 1) {
            return 1;
        }
        int left = 1;
        int right = n;
        int mid;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            }
            else {
                left = mid + 1; 
            }
        }
        return right; 
    }
}