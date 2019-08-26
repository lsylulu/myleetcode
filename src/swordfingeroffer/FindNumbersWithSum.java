package swordfingeroffer;

import java.util.ArrayList;

public class FindNumbersWithSum {

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            int target = sum - array[i];
            boolean flag=false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > target) {
                    break;
                } else if (array[j] == target) {
                    flag=true;
                    res.add(array[i]);
                    res.add(array[j]);
                }
            }
            if(flag){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        ArrayList<Integer> res = FindNumbersWithSum(arr, 15);
        for (Integer re : res) {
            System.out.println(re);
        }

    }
}
