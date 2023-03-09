package leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author : wzq
 * @Date : 2023/3/9
 * @Version : 1.0
 * @Description : 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
 **/
public class T3 {

    public static void main(String[] args) {
        int length = T3.lengthOfLongestSubstring3(" ");
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        int maxSub = 0;

        for (int i = 0; i < s.length(); i++) {

            int subLen = 0;
            for (int j = i; j < s.length(); j++) {
                if (hashMap.get(s.charAt(j)) != null) {
                    break;
                }
                hashMap.put(s.charAt(j), j);
                subLen++;
            }

            maxSub = maxSub > subLen ? maxSub : subLen;
            hashMap.clear();
        }
        return maxSub;
    }

    public static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxSub = 0;
        for (int i = 0; i < s.length(); i++) {
            int subLen = 0;
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) break;
                subLen++;
            }
            maxSub = maxSub > subLen ? maxSub : subLen;
            set.clear();
        }
        return maxSub;
    }

    public static int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) != null) {
                //存在该字符滑动左指针
                left = Math.max(left, map.get(s.charAt(i)));
            }

            map.put(s.charAt(i), i + 1);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
