package leetcode;

import java.util.HashMap;

/**
 * @Author : wzq
 * @Date : 2023/11/1
 * @Version : 1.0
 * @Desc : 两数之和，https://leetcode-cn.com/problems/two-sum
 **/
public class T0001 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = T0001.twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.print(anInt+"-");
        }
    }

    public static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i= 0;i<nums.length;i++){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{i,hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }
}
