/**
Approach 2: Use two Prioirty Queues (smallHeap and largeHeap)
add Num: 
always add it to small Heap.
if size of small heap is > large heap or smallHeap peak is greater than large heap peek
poll top element of smallHeap and put it in large heap.

find Median: 
if size of PQs are same, peek top elements and return average. 
             If size of small Heap is more, return smallHeap peek 
             or return large heap peek. 

 */

class MedianFinder {

    Queue<Integer> smallHeap; // holds all small values and top is largest of the small values.
    Queue<Integer> largeHeap; // holds all larger values and top is smallest of the larger values. 

    public MedianFinder() {

        smallHeap = new PriorityQueue<Integer>((a, b) -> b - a); // maxHeap of min values
        largeHeap = new PriorityQueue<Integer>(); // minHeap of max values

        
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);

        if (smallHeap.size() - largeHeap.size() > 1 || !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.offer(smallHeap.poll());
        }

        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.offer(largeHeap.poll());
        }
        
    }
    
    public double findMedian() {

        if (smallHeap.size() == largeHeap.size()) return (smallHeap.peek() + largeHeap.peek())/2.0;
        if (smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        } else {
            return largeHeap.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
