import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters based on frequency
        List<Character> charList = new ArrayList<>(freqMap.keySet());
        charList.sort((a, b) -> freqMap.get(b) - freqMap.get(a)); // Sort in descending order

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            result.append(String.valueOf(c).repeat(freqMap.get(c))); // Append character multiple times
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.frequencySort("tree"));  // Output: "eert" or "eetr"
        System.out.println(sol.frequencySort("cccaaa")); // Output: "aaaccc"
        System.out.println(sol.frequencySort("Aabb"));   // Output: "bbAa"
    }
}
