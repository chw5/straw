package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : wzq
 * @Date : 2023/3/17
 * @Version : 1.0
 * @Description : 15. 三数之和
 *  https://leetcode.cn/problems/3sum/?favorite=2cktkvj
 **/
public class T15 {

    Integer x = 0;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = T15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            for (int j = i+1; j < length; j++) {

                for (int k = j+1; k < length; k++) {
                    if (k == j && j== i){
                        continue;
                    }
                    if (nums[i]+nums[j]+nums[k] == 0){
                        res.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]}));
                    }
                }
            }
        }
        return res;
    }
}
