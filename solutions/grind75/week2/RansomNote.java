package solutions.grind75.week2;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
        public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineCount = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char curr = magazine.charAt(i);

            if (magazineCount.containsKey(curr)) {
                int count = magazineCount.get(curr);
                count++;
                magazineCount.put(curr, count);
            } else {
                magazineCount.put(curr, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char curr = ransomNote.charAt(i);

            if (magazineCount.containsKey(curr)) {
                int count = magazineCount.get(curr);
                if (count == 1) {
                    magazineCount.remove(curr);
                } else {
                    count = count - 1;
                    magazineCount.put(curr, count);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
