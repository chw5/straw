package thread;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k){
                return true;
            }
            map.put(num,i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums,3));
    }
}