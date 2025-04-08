/**
Optimal Approach: Breadth-First Search (BFS)

Why BFS?
Since we need the shortest transformation sequence, BFS is the best choice because it explores all words at the current level before moving deeper.

Algorithm
Convert wordList into a HashSet for O(1) lookups.
Use a queue for BFS traversal.
Each node represents a word and its transformation depth.

Perform BFS:
Try changing each letter from 'a' to 'z'.
If the transformed word exists in wordList, add it to the queue.
Stop when endWord is reached.
If endWord is never reached, return 0.


Time Complexity
O(N × L × 26), where:
N is the number of words in wordList.
L is the length of each word.
26 is the number of possible letter changes.

 */


import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;  // start with level 1 (beginWord)

        while (!queue.isEmpty()) {
            int size = queue.size();  // number of elements at this level

            // Process one full level
            for (int s = 0; s < size; s++) {
                String curr = queue.poll();
                char[] currArr = curr.toCharArray();

                for (int i = 0; i < currArr.length; i++) {
                    char originalChar = currArr[i];

                    for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                        if (ch2 == originalChar) continue;

                        currArr[i] = ch2;
                        String newWord = new String(currArr);

                        if (newWord.equals(endWord)) {
                            return length + 1;  // found shortest transformation
                        }

                        if (words.contains(newWord)) {
                            queue.offer(newWord);
                            words.remove(newWord);  // mark as visited
                        }
                    }

                    currArr[i] = originalChar;  // restore the character
                }
            }

            length++;  // increment after one full level
        }

        return 0;  // no transformation found
    }
}
