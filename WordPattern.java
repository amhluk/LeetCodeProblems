// 290. Word Pattern
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null && pattern == null) { // empty inputs
            return true;
        }
        if (str == null || pattern == null) { // one input is empty
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String words[] = str.split(" ");
        
        if (pattern.length() != words.length) { // different lengths
            return false;
        }
        
        for (int i = 0; i < pattern.length(); i++) {
            char curChar = pattern.charAt(i);
            if (map.containsKey(curChar)) { // check hashmap
                if (!words[i].equals(map.get(curChar))) {
                    return false;
                }
            } else if (set.contains(words[i])) { // check set
                return false;
            } else {
                map.put(curChar, words[i]);
                set.add(words[i]);
            }
        }
        
        return true;
    }
}