// 344. Reverse String
public class Solution {
    public String reverseString(String s) {
        StringBuilder ret = new StringBuilder(s); // initialize stringbuilder
        ret.reverse(); // reverse stringbuilder
        return ret.toString(); // return as string
    }
}
