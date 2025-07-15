```java
Set<List<Integer>> mySet = new HashSet<>();

// After adding your data to mySet

ArrayList<ArrayList<Integer>> myList = new ArrayList<>();

for (List<Integer> list : mySet) {
    myList.add(new ArrayList<>(list));  // Wrap List into ArrayList
}
```
