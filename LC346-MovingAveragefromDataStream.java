class MovingAverage {
    
    int size;
    double sum;
    int avg;
    List<Integer> list = new ArrayList<>();
    public MovingAverage(int size) {
        this.size = size;
        
    }
    
    public double next(int val) {
        if (list.size() < size) {
            list.add(val);
            sum+=val;
        } 
        else {
            int oldVal = list.remove(0);
            sum -= oldVal;
            list.add(val);
            sum+=val;
        }
        return (double) sum/list.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
