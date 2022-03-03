import java.util.concurrent.Callable;

public class Test<T> {

    public static void main(String[] args) {

    }



    /*public int lengthOfLongestSubstring(String s) {

//        Map<Character,Integer> map = new HashMap();
//        int ans = 0;
//        for(int i = 0,j = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(map.containsKey(c)){
//                j = Math.max(map.get(c),j);//获取该字符第一次出现的下标
//            }
//            ans = Math.max(ans,i - j);//获得不含重复字符的 最大长度
//
//            map.put(s.charAt(i),i);//将字符加入map, map会更新后面出现的字符下标
//        }
//        return ans;
         int n = s.length(), ans = 0;
         Map<Character, Integer> map = new HashMap<>();
         for (int end = 0, start = 0; end < n; end++) {
             char alpha = s.charAt(end);
             if (map.containsKey(alpha)) {
                 start = Math.max(map.get(alpha), start);
             }
             ans = Math.max(ans, end - start + 1);
             map.put(s.charAt(end), end + 1);
         }
         return ans;
    }*/



}
