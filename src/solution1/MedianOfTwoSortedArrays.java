package solution1;

/**
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 */
public class MedianOfTwoSortedArrays {
    /**
     * 中位数必然是走了(m+n)/2+1步就找到了
     * 而且必然是偶数时是(big+small)/2
     * 奇数时是big
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //small记录本次后移前指向的数，big记录移动后指向的数
        int small=0,bigger=0;
        int totalLength=nums1.length+nums2.length;
        int step=totalLength>>1;
        for(int i=0,i1=0,i2=0;i<=step;i++){
            //第一个数组出界的情况
            if(i1>=nums1.length){
                small=bigger;
                bigger=nums2[i2++];
            }
            //第二个数组出界的情况
            else if(i2>=nums2.length){
                small=bigger;
                bigger=nums1[i1++];
            }
            else{
                //类似外部排序
                if(nums1[i1]<=nums2[i2]){
                    small=bigger;
                    bigger=nums1[i1++];
                }
                else{
                    small=bigger;
                    bigger=nums2[i2++];
                }
            }
        }
        return (totalLength&1)!=1?(small+bigger)/2D:bigger;
    }


}
