package solution4;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class FirstAndLastElementInSortedArray {

    /**
     * 二分法找到target，然后去前面和后面找相同元素
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int idx = search(nums, 0, nums.length - 1, target);
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        int left = idx, right = idx;
        //向左查找 记录最左边等于target的下标
        while (left > 0 && nums[left - 1] == nums[idx]) {
            left--;
        }
        //向右查找 记录最右边等于target的下标
        while (right < nums.length - 1 && nums[right + 1] == nums[idx]) {
            right++;
        }
        return new int[]{left, right};
    }

    /**
     * 二分法查找
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int search(int nums[], int low, int high, int target) {
        if (high < low) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < nums[high]) {
            if (nums[mid] < target && target <= nums[high]) {
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        } else {
            if(target<nums[mid]&&target>=nums[low]){
                return search(nums,low,mid-1,target);
            } else {
                return  search(nums,mid+1,high,target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1};
        int[] res=searchRange(nums,1);
        System.out.println(res);
    }

}
