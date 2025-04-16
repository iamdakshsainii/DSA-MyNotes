**🌟 Backtracking Introduction:**
Backtracking is a general algorithmic technique that is used to find all (or some) solutions to a problem. It explores all possible options and returns to the previous step (backtracks) when it finds that a solution is not feasible.

**Core Concept of Backtracking:**
Search space exploration: Backtracking is essentially an exploration of all possible solutions. It goes step by step, checking each possible solution.

Undoing decisions: Whenever a solution doesn’t seem promising, you backtrack and undo some of the decisions made earlier in the process, essentially pruning the search space.

Recursive problem-solving: Backtracking is typically implemented using recursion because the process involves making decisions and then undoing them.

**🌈 When to Use Backtracking:**
Backtracking is useful when you're dealing with problems that can be solved by exploring all possibilities in a systematic way but have a feasible solution that can be reached by pruning the search space (by undoing some decisions).

**Key Indicators to Use Backtracking:**
The problem involves combinations, permutations, or a search space that has multiple possible solutions.

You need to find all possible solutions or some specific solution (for example, a valid combination or permutation).

The solution space can be pruned. If you recognize an invalid path, you can stop exploring further down that path and "backtrack."

The problem has constraints that require making decisions and checking their validity step by step.

**📚 Common Backtracking Problems (Popular in Interviews):**
Generate Parentheses (Like the example above):

Problem: Generate all combinations of valid parentheses given n pairs.

Reason: It’s a combination problem where you need to generate all possible valid combinations and prune invalid ones.

Sudoku Solver:

Problem: Solve a Sudoku puzzle by filling in the missing values.

Reason: The search space is large, but there are constraints to prune invalid moves quickly.

N-Queens Problem:

Problem: Place n queens on an n x n chessboard such that no two queens threaten each other.

Reason: It’s a constraint satisfaction problem where you must check each row, column, and diagonal to ensure no queens can attack each other.

Subset Sum Problem:

Problem: Find subsets of a given set that sum up to a specific target.

Reason: You explore all subsets and backtrack when a subset sum exceeds the target.

Permutations/Combinations:

Problem: Generate all permutations/combinations of a set of elements.

Reason: You need to explore all possible selections of elements, pruning as you go.

Word Search:

Problem: Find if a word exists in a grid of characters.

Reason: You explore all possible paths through the grid, backtracking when you hit an invalid path.

**📜 Backtracking Template**
1. Using String Method (as we did in the Generate Parenthesis problem):
Here’s the string method where we modify the string by adding a character, recursing, and then removing the character (backtracking).

```java
class Solution {
    public void backtracking(List<String> ans, int openCnt, int closeCnt, String currentStr, int n) {
        // Base Case: If the current string length equals 2 * n, a valid solution is found
        if (openCnt + closeCnt == 2 * n) {
            ans.add(currentStr);  // Add the current valid string to the result list
            return;  // Exit the current recursive call
        }

        // Add '(' if the number of open parentheses is less than n
        if (openCnt < n) {
            currentStr = currentStr + '(';  // Add an open parenthesis to the string
            backtracking(ans, openCnt + 1, closeCnt, currentStr, n);  // Recurse with the updated string
            currentStr = currentStr.substring(0, currentStr.length() - 1);  // Backtrack by removing '('
        }

        // Add ')' if the number of close parentheses is less than the number of open parentheses
        if (closeCnt < openCnt) {
            currentStr = currentStr + ')';  // Add a close parenthesis to the string
            backtracking(ans, openCnt, closeCnt + 1, currentStr, n);  // Recurse with the updated string
            currentStr = currentStr.substring(0, currentStr.length() - 1);  // Backtrack by removing ')'
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, 0, 0, "", n);  // Start with an empty string
        return ans;
    }
}

```

**📋 Explanation of Steps for the String Method:**
**Add a Choice**: In this case, we modify the string currentStr by appending '(' or ')' based on the conditions (e.g., openCnt < n).

**Recurse**: After adding a character, we recursively call the backtracking function to explore further with the updated state.

**Remove the Choice:** After the recursive call, we remove the last character (using substring()) to undo the choice and backtrack.

