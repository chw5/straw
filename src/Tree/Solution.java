package Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {

    /**
     * https://leetcode-cn.com/problems/container-with-most-water/
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int ans = 0;
        int l = 0,r = height.length - 1;
        while (l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans,area);
            if (height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }

    /**
     * 三数之和：先排序，再用三个指针
     * url：https://leetcode-cn.com/problems/3sum/
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) return ans;

        int n = nums.length;
        Arrays.sort(nums); //排序

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环

            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重

            int L = i + 1;
            int R = n - 1;
            while (L < R){
                int sum = nums[i] + nums[L] +nums[R];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L++;//去重
                    while (L < R && nums[R] == nums[R-1]) R--;//去重
                    L++;
                    R--;
                }else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


}
