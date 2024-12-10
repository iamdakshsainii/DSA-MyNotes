iska refernce tum sort method for frequency m jake le skte ho kyuki phle 
tumhe list bnani hogi then ye hoga to list vha dekhlo aur niche bhi de dete hi

 List<Map.Entry<Character, Integer>> entries = new ArrayList<>(freqMap.entrySet());


// bubble sort ki trh hi chlega
// Step : Apply Bubble Sort to sort by frequency (descending order)
int n = entries.size();
for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
        // Simplified Swap logic
        if (entries.get(j).getValue() < entries.get(j + 1).getValue()) // get(j).getValue() > mean first go 
                    //to first pair and then value in pair and so on for all pairs

            // Swap using a simple temporary variable (less complex)
            Map.Entry<Character, Integer> temp = entries.get(j);
            entries.set(j, entries.get(j + 1));
            entries.set(j + 1, temp);
        }
    }



Comparison of Direct Method vs. Bubble Sort
Bubble Sort:

Time Complexity: O(n²) in the worst case. This makes Bubble Sort significantly slower for large datasets.

Space Complexity: O(1) if you’re using the in-place version of Bubble Sort (which doesn’t require extra space).

Stability: Bubble Sort is stable, meaning that if two entries have the same frequency, 
their order will remain the same as it was initially.

Comparison and Which One is Better:
Performance: The direct method (using Collections.sort) is much faster for larger datasets because 
it runs in O(n log n) time, which is more efficient than the O(n²) time of Bubble Sort.

Simplicity: The direct method is simpler to implement and more reliable, 
as it uses Java's built-in highly optimized sorting algorithms.

Readability: The direct method is more concise and easier to understand.

Conclusion:
For most cases, using Collections.sort is the best option because of its better performance and simpler code.

Bubble Sort is primarily educational and should be used for small datasets or for learning purposes about sorting algorithms.
