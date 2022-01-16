package com.sun.everyday;

/**
 * @author sunyl
 * @date 2022/1/7 10:09 上午
 * @see com.sun.everyday
 */
public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        int depth = 0, n = s.length();
        for (int i = 0, cnt = 0; i < n; i++) {
            char ch = s.charAt(i);
            if ('(' == ch) {
                cnt++;
                depth = Math.max(depth, cnt);
            } else if (')' == ch) {
                cnt--;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses solution = new MaximumNestingDepthOfTheParentheses();
        System.out.println(solution.maxDepth(""));
        System.out.println(solution.maxDepth("()"));
        System.out.println(solution.maxDepth("()(()())"));
        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
