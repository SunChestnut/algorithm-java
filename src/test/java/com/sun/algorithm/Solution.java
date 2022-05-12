package com.sun.algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunyl
 * @date 2022/1/10 3:26 下午
 * @see com.sun.algorithm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Solution {

    static class PrivateTreeNode {
        int val;
        PrivateTreeNode left;
        PrivateTreeNode right;

        PrivateTreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(PrivateTreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    private static boolean recur(PrivateTreeNode left, PrivateTreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null || right == null) || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    @Test
    public void isValid() {
        String s = "{[())]}";

        Map<Character, Character> couple = new HashMap<>(3);
        couple.put(')', '(');
        couple.put('}', '{');
        couple.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curValue = s.charAt(i);
            if (couple.containsKey(curValue)) {
                Character popValue = stack.pop();
                if (!popValue.equals(couple.get(curValue))) {
                    System.out.println(false);
                    break;
                }
            } else {
                stack.push(curValue);
            }
        }
        System.out.println(stack.size() == 0);
    }
}
