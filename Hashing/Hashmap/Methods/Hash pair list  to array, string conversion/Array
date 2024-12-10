Reference- top k element leetcode problem


// Convert to list of entries and sort by frequency
List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
entries.sort((a, b) -> b.getValue() - a.getValue());
int[] result = new int[k];
for (int i = 0; i < k; i++) {
result[i] = entries.get(i).getKey();// get(i) hr pair pr jane ko and getKey() hr key of that pair par jane k liye
}

return result;