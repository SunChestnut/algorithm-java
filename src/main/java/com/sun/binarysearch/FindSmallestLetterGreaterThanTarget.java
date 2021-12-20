package com.sun.binarysearch;

/**
 * @author sunyl
 * @date 2021/12/20 10:11 上午
 * @see com.sun.binarysearch
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c - target > 0) {
                return c;
            }
        }
        return letters[0];
    }

    public char nextGreatestLetterBinarySearch(char[] letters, char target) {
        int left = 0, right = letters.length, mid;
        // 为什么 right = letters.length 而不是 letters.length-1，这样不会发生数组越界么？
        // 不会，因为如果在有序数组中查找的目标位置偏向右侧时，left 指针不断右移动，最后会发生 left = right，此时循环终止
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 当 letters 中不存在比 target 更大的值时，应返回 letters[0]
        // 此时 Left 指针所在的位置应该是 letters.length，运用取模运算，就可以得到 letters[0]
        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget solution = new FindSmallestLetterGreaterThanTarget();
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'z'));


//        System.out.println(solution.nextGreatestLetterBinarySearch(new char[]{'c', 'f', 'j'}, 'c'));
//        System.out.println(solution.nextGreatestLetterBinarySearch(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(solution.nextGreatestLetterBinarySearch(new char[]{'c', 'f', 'j'}, 'z'));

    }

}
