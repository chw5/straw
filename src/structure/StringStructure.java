package structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class StringStructure {

    /**
     * 字符串反转
     * @param s
     */
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i=0,j=len-1;i<len/2;i++,j--){
            char tem = s[i];
            s[i] = s[j];
            s[j] = tem;
        }
    }

    /**
     * 整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = res * 10 + x % 10;
            if (tmp / 10 != res) { // 溢出!!!
                return 0;
            }
            res = tmp;
            x /= 10;
        }
        return res;
    }

    /**
     * 字符串中的第一个唯一字符
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断两个字符串是否互为异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 判断是否回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(char c:chars){
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        StringBuffer sbReverse = new StringBuffer(sb).reverse();
        if (sb.toString().equals(sbReverse.toString())){
            return true;
        }
        return false;
    }


}
