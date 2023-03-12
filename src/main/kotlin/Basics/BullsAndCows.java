package Basics;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public static String guessAnswer (String secret, String guess) {
        int numBulls = 0;
        int numCows = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char secretCount = secret.charAt(i);
            char guessCount = guess.charAt(i);
            if (secretCount == guessCount) {
                numBulls++;
            } else {
                //1807  secret
                //7810  guess
                //1A3B
                map.put(secretCount, map.getOrDefault(secretCount, 0) + 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char secretCount = secret.charAt(i);
            char guessCount = guess.charAt(i);
            if (secretCount != guessCount) {
                if (map.containsKey(guessCount) && map.get(guessCount) > 0) {
                    numCows++;
                    map.put(guessCount, map.get(guessCount) - 1);
                }
            }
        }

        return numBulls + "A" + numCows + "B";
    }
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println(guessAnswer(secret, guess));
    }
}
