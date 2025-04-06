/**

Minimum Time = max(tasks.length, (f_max - 1) * (n + 1) + maxCount)

- create freqCount array for tasks 'A-Z'. Use array for chars, Each index represents a task character.
- sort the freqCount to get the maxFrequency. Sort so the highest frequency task comes at the end.
- compute maxCount, count of tasks with maxFrequency
- sectionCount is maxFrequency -1. Because last task doesn't need a trailing gap.
- sectionRemainingLength is n(intervals between two tasks) - count of tasks with maxFrequency -1
- empty slots are which slots remain after considering the tasks with max frequency in each section i.e. sectionCount * sectionRemainingLength
- Available tasks are tasks that can be used to fill the empty slots is what is remaining in tasks array after accounting for tasks with max frequency in each section. 
- idles are slots where we don't have any tasks to fill with. Math.max(0, emptySlots - availableTasks)
- return the tasks.length + idles. After placing other maxFrequency tasks into gaps

 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        char[] freqCount = new char[26];

        for (int i=0; i<tasks.length; i++) {
            freqCount[tasks[i]-'A']++;
        }

        Arrays.sort(freqCount);

        int maxFrequency = freqCount[25];
        int maxCount = 1;

        for(int i = 24; i>=0; i--) {
            if(freqCount[i] == maxFrequency) {
                maxCount++;
            }
        }

        int sectionCount = maxFrequency -1;
        int sectionRemainingLength = n - (maxCount -1);
        int emptySlots = sectionCount * sectionRemainingLength;
        int availableTasks = tasks.length - (maxFrequency * maxCount);
        int idles = Math.max(0, emptySlots - availableTasks);
        

        return tasks.length + idles;


    }
}
