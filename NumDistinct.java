// 115. Distinct Subsequences
public class Solution {
    
    // naive solution using recursion
    public int numDistinctNaive(String s, String t) {
        if (t.length() == 0) { // T is empty, number of substrings will always be 1
            return 1;
        }
        if (s.length() == 0) { // S is empty but T is not, number of substrings will always be 0
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) { // if characters match, check substring of rest of strings
                count += numDistinctNaive(s.substring(i + 1), t.substring(1));
            }
        }
        return count;
    }
    
    // O(MN) space solution using 2D table
    public int numDistinctMN(String s, String t) {
        int[][] numDisTable = new int[s.length() + 1][t.length() + 1]; // table for DP
        
        for (int i = 0; i <= s.length(); i++) { // T is empty, number of substrings will always be 1
            numDisTable[i][0] = 1;
        }
        for (int j = 1; j <= t.length(); j++) { // S is empty but T is not, number of substrings will always be 0
            numDisTable[0][j] = 0;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                numDisTable[i][j] = numDisTable[i - 1][j]; 
                if (s.charAt(i - 1) == t.charAt(j - 1)) { 
                    numDisTable[i][j] += numDisTable[i - 1][j - 1];
                }
            }
        }
        
        return numDisTable[s.length()][t.length()];
    }

    // O(N) space solution
    public int numDistinct(String s, String t) {
        int[] numDisTable = new int[t.length() + 1]; // table for DP
        
        numDisTable[0] = 1; // T is empty, number of substrings will always be 1
        
        for (int j = 1; j <= t.length(); j++) {  // S is empty but T is not, number of substrings will always be 0
            numDisTable[j] = 0;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            int lastVal = numDisTable[0];
            for (int j = 1; j <= t.length(); j++) {
                int curVal = numDisTable[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    numDisTable[j] += lastVal;
                }
                lastVal = curVal;
            }
        }
        
        return numDisTable[t.length()];
    }
}