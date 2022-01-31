import java.util.PriorityQueue;

//we break the stream into two: min and max
//maximum of min will give first number and minimum of min will given second number in case of even medium
//maximum of min will give median in case of odd median
//we maintain the heap size of min and max and min should always be less than max, when a new value is added
//so we first add it to min and move largest element of min to max


public class Greedy_Leetcode_295_FindMedianFromDataStream {
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void MedianFinder() {
    }

    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        if (min.size() < max.size()) {
            min.offer(max.poll());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return min.peek();
        }
    }
}
