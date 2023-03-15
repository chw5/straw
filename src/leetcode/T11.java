package leetcode;

/**
 * @Author: wzq
 * @Date: 2023/3/15
 * @Desc: 11. 盛最多水的容器（双指针算法）
 * https://leetcode.cn/problems/container-with-most-water/
 **/
public class T11 {

    public static void main(String[] args) {
      int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = T11.maxArea(height);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int res = 0;//面积最大值

        while (i < j) {
            res = height[i] > height[j] ? Math.max(res,(j - i)*height[j--]) : Math.max(res,(j - i)*height[i++]);
        }

        return res;
    }
}
