package solution2;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class ContainerWithMostWater {

    /**
     * 方法1，暴力法
     * 只要保证数组中任意两个数的最小值*索引差值最大就是答案
     * 该方法的时间复杂度为O(n^2)
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int res=0;
        for(int i=0;i<height.length;i++){
            for(int j=i;j< height.length;j++){
                //Math.min(height[i],height[j])*(j-i)就是
                //当前i，j组合的积
                    res=Math.max(res,Math.min(height[i],height[j])*(j-i));
            }
        }
        return res;
    }

    /**
     * 方法2，双指针法
     * 左右各一个指针，每次以牺牲宽度为代价
     * 寻找相对长一点的高度
     * 时间复杂度为O(n)
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxarea = 0;
        //左指针
        int l = 0;
        //右指针
        int r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            //当左指针数太小了，就向右移动
            if (height[l] < height[r]) {
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
}
