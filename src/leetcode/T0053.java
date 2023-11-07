package leetcode;

/**
 * @Author : wzq
 * @Date : 2023/11/2
 * @Version : 1.0
 * @Desc :最大子序和：https://leetcode-cn.com/problems/maximum-subarray/
 **/
public class T0053 {


    public int maxSubArray(int[] nums) {

        int sum=0 ,max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = (max < sum)?sum:max;
            }
        }
        return max;
    }

}
