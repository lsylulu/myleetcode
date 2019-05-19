package solution5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, int[] nums, int cur) {
        //设置递归终点，cur走到头了本次也就交换完了
        if (cur == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (Integer item : nums) {
                temp.add(item);
            }
            System.out.println(temp);
            System.out.println("-------------");
            res.add(temp);
        } else {
            //从当前元素开始向后遍历
            for (int i = cur; i < nums.length; i++) {
                swap(nums, cur, i);
                dfs(res, nums, cur + 1);
                //这里一定要交换回来，因为是引用，不能改变，不然得不到正确的结果
                swap(nums, cur, i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        permute(nums);
    }
}
