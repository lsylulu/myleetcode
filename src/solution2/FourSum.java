package solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    /**
     * 和三数之和为0那题类似，只是多了一层循环，把0换成target而已
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            //防止连续几个nums[i]相同情况的出现
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                //防止连续几个nums[j]相同情况的出现
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //为了避免重复，left应该从i的右边开始
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[j] + nums[i];
                    if (right == j) {
                        right--;
                        continue;
                    }
                    //三数之和为0
                    if (sum == target) {
                        List<Integer> element = new ArrayList<>();
                        element.add(nums[left]);
                        element.add(nums[right]);
                        element.add(nums[j]);
                        element.add(nums[i]);
                        res.add(element);

                        //避免相同元素刚好三数之和为0的情况
                        while (left + 1 < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right - 1 > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //必须先判重，再跳到下一个位置，因为上面两个while只会让指针到达最后一个
                        //相同元素的位置
                        left++;
                        right--;
                    } else if (sum > target) {
                        //说明此时正数太大了，适当的小一点
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
