package solution5;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
public class JumpGameii {

    public static int jump(int[] nums) {
        if(nums.length<2) {
            return 0;
        }
        //统计次数
        int times=0;
        //能跳到的最大的索引位置
        int max_loc=0;
        //下一次开始跳的索引位置
        int next_begin=0;
        for(int i=0;i<nums.length;i++){
            //当点能跳到的最大的距离
            max_loc=Math.max(max_loc,i+nums[i]);
            System.out.println(max_loc);
            //超过或者等于的时候 并没有给times+
            if(max_loc>=nums.length-1){
                return times+1;
            }
            //当i指针指向了下一次跳的位置的时候
            if(i==next_begin){
                times++;
                next_begin=max_loc;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        int[] nums={2,1,3,1};
        jump(nums);
    }
}
