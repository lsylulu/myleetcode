package solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        //记录每一次的结果
        List<Integer> help = new ArrayList<>();

        //最终的返回值
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        find(candidates, target, help, res, 0);

        return res;
    }

    /**
     * 遍历candidates，对于每一次的遍历，都给它从指定位置开始找一遍，看看有没有匹配的
     *
     * @param candidates
     * @param target
     * @param tmp
     * @param res
     * @param num        避免重复情况，不要从头开始找
     */
    public static void find(int[] candidates, int target, List<Integer> tmp, List<List<Integer>> res, int num) {

        //递归结束条件
        if (target == 0) {
            res.add(tmp);
            return;
        }
        //target小于最小数，不可能满足
        if (target < candidates[0]) {
            return;
        }
        for (int i = num; i < candidates.length && target >= candidates[i]; i++) {
            //尝试将当前元素添加至help中，如果在递归过程中return了
            //就继续用tmp往后判断
            List<Integer> help = new ArrayList<>(tmp);
            help.add(candidates[i]);
            find(candidates, target - candidates[i], help, res, i);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }
}
