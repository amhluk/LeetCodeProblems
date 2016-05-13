// 278. First Bad Version
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int L = 1;
        int R = n;
        while (L < R) {
            int M = L + (R - L)/2;
            if (isBadVersion(M)) {
                R = M;
            } else {
                L = M + 1;
            }
        }
        return R;
    }
}