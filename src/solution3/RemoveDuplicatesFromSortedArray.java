package solution3;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 定义两个指针，慢指针i和快指针j。
     * 快指针每次走一步
     * 慢指针遇到相同的就不动，否则就走一步
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        if(nums.length==0||nums==null){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            //正常请况下nums[i]!=nums[j]
            //nums[++i]==nums[j]
            //出现相同元素时，i不动，随着j++，走到与i不同的元素时
            //就把nums[j]赋值给nums[i]
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return  i+1;
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,2,2,3,5};
        System.out.println(removeDuplicates(nums));
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
