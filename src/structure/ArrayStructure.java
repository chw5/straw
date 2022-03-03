package structure;

import java.util.*;

public class ArrayStructure {

    /**
     * 删除排序数组中的重复元素
     *
     * @param nums
     * @return
     */
    //双指针解决
    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
                continue;
            }
            nums[++i] = nums[j++];
        }
        return i + 1;
    }

    /**
     * 买卖股票的最佳时机 II
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //原数组中如果后一个减去前一个是正数，说明是上涨的，
            //我们就要累加，否则就不累加
            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        return total;
    }

    /**
     * 反转数组
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    /**
     * 存在重复元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return true;
            }

        }
        return false;
    }

    /**
     * 两数组的交集
     * 思路：先排序，再指针
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list  = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                // 如果i指向的值小于j指向的值，，说明i指向
                // 的值小了，i往后移一步
                i++;
            } else if (nums1[i] > nums2[j]) {
                // 如果i指向的值大于j指向的值，说明j指向的值
                // 小了，j往后移一步
                j++;
            } else {
                // 如果i和j指向的值相同，说明这两个值是重复的，
                // 把他加入到集合list中，然后i和j同时都往后移一步
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        for (int k=0;k<list.size();k++){
            result[k] = list.get(k);
        }
        return result;
    }

    /**
     * 数组表示数，然后加1
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    /**
     * 移动零
     * 思路：双指针
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    /**
     * 两数之和
     * 思路：用HashMap
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) {

        //删除排序数组中的重复元素
        int[] A = {1, 1, 2};
        int i = ArrayStructure.removeDuplicates(A);





    }
}
