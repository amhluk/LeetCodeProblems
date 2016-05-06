// 299. Bulls and Cows
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        /* TWO PASS SOLUTION
        Map<Character, Integer> map = new HashMap<>();
        
        // first pass, check all bulls and add secret to hashmap
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++; // characters are the same, increment bull
                continue;
            }
            
            // update map based on secret
            if (map.containsKey(secret.charAt(i))) {
                map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
            } else {
                map.put(secret.charAt(i), 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }
            // update map based on guess
            if (map.containsKey(guess.charAt(i))) {
                if (map.get(guess.charAt(i)) == 1) {
                    map.remove(guess.charAt(i));
                } else {
                    map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                }
                cows++; // update cows since there is a match in map
            }
        }*/
        
        /* ONE PASS SOLUTION */
        int nums[] = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++; // characters are the same, increment bull
                continue;
            }
            
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            // update nums and cows
            if (nums[s]++ < 0) {
                cows++;
            }
            if (nums[g] -- > 0) {
                cows++;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}