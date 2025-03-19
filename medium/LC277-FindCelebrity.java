/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/**
Approach 1: Two-Pass Algorithm (Elimination Strategy)

Intuition
Find the Celebrity Candidate:
Eliminate non-celebrities in one pass.
If A knows B, A cannot be the celebrity.
If A does not know B, B cannot be the celebrity.
We are left with one possible candidate.
Verify the Candidate:
Check if everyone knows them.
Check if they know no one.

Algorithm
Find the candidate:
Start with candidate = 0.
Loop i = 1 to n-1:
If candidate knows i, update candidate = i (previous one is disqualified).
Verify the candidate:
Check if everyone knows them.
Check if they know no one.

Time Complexity:
O(n) → We only do two passes.

Space Complexity:
O(1) → Uses a few variables.

 */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate=0;
        for (int i=0; i<n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i=0; i<n; i++) {
            if (i != candidate) {
                if(knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
