package solution2;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    /**
     * 只要找到三数之和与target之差绝对值的最小值
     * 就是答案。本题不需要考虑重复情况，结果都是一样的
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        int diff=Math.abs(res-target);
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int newSum=nums[left]+nums[right]+nums[i];
                int newDiff=Math.abs(newSum-target);
                 if(diff>newDiff){
                    //此时需要记录更合适的解
                    diff=newDiff;
                    res=newSum;
                }

                if(newSum>target){
                    right--;
                }else{
                    left++;
                }

            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }

}
