package solution4;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    /**
     * 给定：
     * 1,5,8,5,7,6,4,3,1
     * 先从右向左找刚好降序的那一对数中最小的那个，就是5。
     * 然后找到5后面的恰好比5大的数，交换位置
     * 再将3号索引(之前5所在的索引)后的数逆置，
     * 由于后往前是升序的，所以逆置后必然是最小的字典序，得到答案
     * 1,5,8,5,7,6,4,3,1->1,5,8,4,7,6,5,3,1->1,5,8,4,1,3,5,6,7
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n=nums.length-2;
        //从后往前找，刚好找到nums[n]<nums[n+1]的数
        while(n>=0&&nums[n+1]<=nums[n]){
            n--;
        }

        if(n>=0){
            //去后面找恰好大于它的数
            int m=nums.length-1;
            while(m>=0&&nums[n]>=nums[m]){
                m--;
            }
            swap(nums,n,m);
        }
        //已经不可能找到更小的字典序了，直接反转
        reverse(nums,n+1);

    }

    public  void swap(int nums[],int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void reverse(int nums[],int start){
        int end=nums.length-1;
        while(start<=end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

}
