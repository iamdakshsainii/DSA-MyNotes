entries.sort((a, b) -> a.getValue() - b.getValue());
Sorts the list in increasing order of values. Here's why:

a.getValue(): Retrieves the value of the first entry (a).
b.getValue(): Retrieves the value of the second entry (b).
a.getValue() - b.getValue():
If the result is negative, a is considered smaller than b (i.e., a comes first).
If the result is zero, the order of a and b remains unchanged.
If the result is positive, b is considered smaller than a (i.e., b comes first).
This results in increasing order of the values in the Map.Entry list.


Examples of both order
K Least Frequent Elements
Find the Most Frequent Even Number
Top K Frequent Words
Sort Characters by Frequency