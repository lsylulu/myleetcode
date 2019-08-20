package swordfingeroffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {


    /**
     * 利用一个大根堆，小数到达，顶替堆顶
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
