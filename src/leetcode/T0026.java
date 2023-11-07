package leetcode;

/**
 * @Author : wzq
 * @Date : 2023/11/2
 * @Version : 1.0
 * @Desc :删除排序数组中的重复项：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 **/
public class T0026 {

    public int removeDuplicates(int[] nums) {

        int p = 0,q = 1;
        while (q < nums.length){
            if (nums[p] != nums[q]){
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
