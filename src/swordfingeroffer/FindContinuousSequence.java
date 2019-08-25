package swordfingeroffer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int low=1,high=2;

        while(high>low){
            //sum=（首项+尾项）*项数/2
            int cur=(low+high)*(high-low+1)/2;
            if(cur==sum){
                ArrayList<Integer> arrayList=new ArrayList<>();
                for(int i=low;i<=high;i++){
                    arrayList.add(i);
                }
                res.add(arrayList);
                //找到了，必须增加low才能接着尝试下一个可以的组合
                //因为如果增加high，则只能导致sum比之前的大
                low++;
            }else if(cur<sum){
                high++;
            }else{
                low++;
            }

        }
        return res;
    }
}
