package solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumii {

    /**
     * 和上一题差不多，只不过每个元素只能用一次
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

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
            //防止重复情况
            //1,1,2,5,6,7,10->1,5,6
            //如果不判断，1,5,6会出现两次
            if(i>num&&candidates[i]==candidates[i-1]){
                continue;
            }
            //尝试将当前元素添加至help中，如果在递归过程中return了
            //就继续用tmp往后判断
            List<Integer> help = new ArrayList<>(tmp);
            help.add(candidates[i]);
            find(candidates, target - candidates[i], help, res, i+1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);
    }
}
