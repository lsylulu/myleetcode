package solution5;

import sun.security.util.Length;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive {

    /**
     * 突破口是缺失的第一个整数必然是1-nums.length中的某一个数
     * 可以把大于等于1并且小于数组长度的数字与指定索引下的
     * 数字交换位置，最终遍历一遍，必然能找到缺失的最小数字
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            //这3个判断缺一不可，不加nums[i]!=nums[nums[i]-1]
            //会超出时间限制
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                //交换nums[i]和nums[nums[i]-1]的位置
                //因为索引从0开始，所以是nums[nums[i]-1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        //找到对应索引与当前数不相等的索引
        //返回索引即可
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //此时说明所有的数都是大于等于1的数
        return nums.length + 1;
    }
}
