package swordfingeroffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {

    //记录当前队列中总的数据量，用作奇偶标识
    int count = 0;
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue(10, new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            //大顶堆
            return o2.compareTo(o1);
        }
    });

    /**
     * 两个堆所存放的数据量之差不可超过1，大顶堆的所有数据都小于小顶堆
     *
     * @return
     */
    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 1) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        } else {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    public Double GetMedian() {
        double res = maxHeap.peek();
        return ((count & 1) == 1) ? res : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
