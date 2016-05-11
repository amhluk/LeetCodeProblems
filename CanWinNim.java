// 292. Nim Game
public class Solution {
    public boolean canWinNim(int n) {
        // you can always force a win if you keep ensuring that the stones left is a multiple of 4 if n % 4 != 0
        return (n % 4 != 0);
    }
}