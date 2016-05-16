// 12. Integer to Roman
public class Solution {
    public String intToRoman(int num) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while(num > 0) {
            int timesToAdd = num/values[i];
            for (int j = 0; j < timesToAdd; j++) {
                ret.append(symbols[i]);
            }
            num %= values[i];
            i++;
        }
        return ret.toString();
    }
}