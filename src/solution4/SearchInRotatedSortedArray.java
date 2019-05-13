package solution4;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchInRotatedSortedArray {

    /**
     * 使用二分法，分别将左右两个数组进行查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return smallSearch(nums, target, 0, nums.length - 1);
    }

    public int smallSearch(int[] nums, int target, int begin, int end) {
        //结束条件
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < nums[end]) {
            if (nums[mid] < target && target <= nums[end]) {

                return smallSearch(nums, target, mid + 1, end);
            } else {
                return smallSearch(nums, target, begin, mid - 1);
            }
            //此时mid在左半段
        } else {
            //5,6,7,8,9  1,2,3,4,5
            //target正好在一端升序的begin-end中
            if (nums[begin] <= target && target < nums[mid]) {
                return smallSearch(nums, target, begin, mid - 1);
            } else {
                return smallSearch(nums, target, mid + 1, end);
            }
        }
    }
}
