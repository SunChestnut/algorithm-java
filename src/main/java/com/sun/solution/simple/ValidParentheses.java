package com.sun.solution.simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * 【简单 Solution20】
 * 题目：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1⃣️ 左括号必须用相同类型的右括号闭合。
 * 2⃣️ 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * ----------------------------------------------------------
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * ----------------------------------------------------------
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * ----------------------------------------------------------
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * ----------------------------------------------------------
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * ----------------------------------------------------------
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * ----------------------------------------------------------
 *
 * @author syl
 * @date 2020/02/01 - 09:03
 */
public class ValidParentheses {

    private HashMap<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    /**
     * 1⃣️ 初始化栈s
     * 2⃣️ 一次处理表达式的每个括号。
     * 3⃣️ 如果遇到开括号（左括号），将其推到栈上即可
     * 4⃣️ 如果遇到一个闭括号，检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么将它从栈中弹出并继续处理。否则，这意味着表达式无效。
     * 5⃣️ 如果到最后剩下的栈中仍然有元素，那么这意味着表达式无效。
     *
     * @param s 源字符
     * @return 是否有效
     */
    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty,set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(c)) {
                    return false;
                }

            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid(s1));
        System.out.println(vp.isValid(s2));
        System.out.println(vp.isValid(s3));
        System.out.println(vp.isValid(s4));
        System.out.println(vp.isValid(s5));
    }
}
