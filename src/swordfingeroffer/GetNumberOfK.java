package swordfingeroffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {

    /**
     * 换个思路，拿k+0.5和k-0.5的下标即可
     * @param arr
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] arr, int k) {

        int rightIndex = search(arr, k + 0.5);
        int leftIndex = search(arr, k - 0.5);

        if (arr.length == 0 || rightIndex == -1) {
            return 0;
        }
        return rightIndex - leftIndex;
    }

    public int search(int[] arr, double num) {
        int begin = 0, end = arr.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 2);
            if (arr[mid] < num) {
                begin = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            }
        }
        return begin;
    }
}
