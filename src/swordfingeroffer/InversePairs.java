package swordfingeroffer;


/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {

    public int InversePairs(int[] arr) {
        if (arr != null && arr.length != 1) {
            int res = mergeSort(arr, 0, arr.length - 1);
            res%=1000000007;
            return res;
        }
        return 0;
    }

    private int mergeSort(int[] arr, int begin, int end) {
        if (begin == end) {
            return 0;
        }
        int cur = begin + ((end - begin) >> 2);
        return mergeSort(arr, begin, cur)%1000000007 + mergeSort(arr, cur + 1, end)%1000000007 + merge(arr, begin, cur, end);
    }

    private int merge(int[] arr, int begin, int mid, int end) {

        int[] help = new int[end - begin + 1];
        int p1 = begin;
        int p2 = mid + 1;
        int index = 0;
        int res = 0;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] <= arr[p2]) {
                help[index++] = arr[p1++];
            } else {
                res += mid - p1 + 1;
                res %= 1000000007;
                help[index++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while (p2 <= end) {
            help[index++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[begin + i] = help[i];
        }
        return res;
    }
}
