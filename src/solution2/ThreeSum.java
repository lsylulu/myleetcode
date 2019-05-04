package solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * 先将数组排序，设置两个指针
     * 一个在当前索引的下一个位置向右走，一个在右边界向左走
     * 重头开始遍历，当三数之和为0时则记录下来
     * 遍历的时候当数组第一个数是整数则直接返回，因为后面的数
     * 必然也是整数，不可能找到想要的结果
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //防止连续几个nums[i]相同情况的出现
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            //为了避免重复，left应该从i的右边开始
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                //三个数都是正数，直接跳过
                if (nums[i] > 0 && nums[left] > 0 && nums[right] > 0) {
                    break;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                //三数之和为0
//                System.out.println(target);
                if (sum == 0) {
                    List<Integer> element = new ArrayList<>();
                    element.add(nums[left]);
                    element.add(nums[right]);
                    element.add(nums[i]);
                    res.add(element);

                    //避免相同元素刚好三数之和为0的情况
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //必须先判重，再跳到下一个位置
                    left++;
                    right--;
                } else if (sum > 0) {
                    //说明此时正数太大了，适当的小一点
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
