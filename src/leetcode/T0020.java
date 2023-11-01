package leetcode;

import java.util.Stack;

/**
 * @Author : wzq
 * @Date : 2023/11/1
 * @Version : 1.0
 * @Desc : 有效的括号:https://leetcode-cn.com/problems/valid-parentheses/description
 **/
public class T0020 {


    public static boolean isValid(String target){

        if (target.isEmpty()){
            return true;
        }

        char[] charArray = target.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
