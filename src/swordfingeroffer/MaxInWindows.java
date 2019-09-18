package swordfingeroffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {

    /**
     * 使用双端队列存储最大值的索引，每次滑动都判断索引是否过期
     * 从队尾开始，把比当前数小的全部丢掉
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        if(size==0){
            return res;
        }
        ArrayDeque<Integer> help = new ArrayDeque<>(size);
        for (int i = 0; i < num.length; i++) {
            int begin = i - size + 1;
            //清理过期的索引
            if (help.isEmpty()) {
                help.add(i);
            } else if (begin > help.peekFirst()) {
                help.pollFirst();
            }

            while (!help.isEmpty() && num[help.peekLast()] <= num[i]) {
                help.pollLast();
            }
            help.add(i);
            if (begin >= 0) {
                res.add(num[help.peekFirst()]);
            }
        }
        return res;
    }
}
