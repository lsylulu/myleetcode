package solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    /**
     * 时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 时间复杂度为O(n),额外空间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> help=new HashMap<>();
        //只遍历一遍
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(help.containsKey(need)){
                return new int[]{i,help.get(nums[i])};
            }
            help.put(nums[i],i);
        }
        throw new RuntimeException("no solution!");
    }

    public static void main(String[] args) {
        int[] nums={3,2,4};
        int []res=twoSum1(nums,6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
