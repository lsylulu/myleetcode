package solution5;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 结合原题的图更直观！
 */
public class TrappingRainWater {

    public static int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            //这是个单调栈
            //当栈非空,并且当前元素比栈顶的元素大
            // 也就是后一个高度比前一个高度高时,进行弹栈结算操作
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //前一个高度
                int temp = stack.pop();
                //如果弹栈后栈为空了,直接跳出循环,说明已经计算结束
                if (stack.isEmpty()) {
                    break;
                }
                //长方形高度就是左右两个的最小高度-自己的高度
                //长方形宽度就是当前索引-之前的较小高度-1
                //长方形高度->Math.min(height[i],height[stack.peek()])-height[temp]
                //长方形宽度->i-stack.peek()-1
                System.out.println("i="+i);
                System.out.println(Math.min(height[i], height[stack.peek()]) - height[temp]);
                res += (Math.min(height[i], height[stack.peek()]) - height[temp])
                        //下标相减计算长方形宽度
                        * (i - stack.peek() - 1);
            }
            //向栈中压入下标,这是第一步做的
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
