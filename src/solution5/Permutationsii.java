package solution5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Permutationsii {

    /**
     * 和上一题类似，就是多了一个判重的方法
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }

    private static void dfs(int[] nums, int cur, List<List<Integer>> res) {
        if (cur == nums.length) {
            List<Integer> help = new ArrayList<>();
            for (Integer integer : nums) {
                help.add(integer);
            }
            System.out.println(help);
            System.out.println("-------------");
            res.add(help);
        } else {
            for (int i = cur; i < nums.length; i++) {

                if (canSwap(nums, cur,i)) {
                    swap(nums, cur, i);
                    dfs(nums, cur+1, res);
                    swap(nums, cur, i);
                }
            }
        }
    }

    private static boolean canSwap(int nums[], int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        permuteUnique(nums);
    }
}
