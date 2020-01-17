package com.sun.algorithm.solution;


import com.sun.algorithm.model.ExampleModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SolutionTest {

    @Test
    public void longSubstringWithoutRepeatingCharTest() {
        String s = ExampleModel.exampleOne;

        Assert.assertEquals(13, LongSubstringWithoutRepeatingChar.slidingWindow(s));
        Assert.assertEquals(13, LongSubstringWithoutRepeatingChar.slidingWindowBetter(s));
    }

    @Test
    public void medianOfTwoSortedArraysTest() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        Assert.assertEquals(2.5, MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2), 0);
    }

    @Test
    public void longestPalindromicSubstringTest() {
        String str = ExampleModel.exampleTwo;
        System.out.println("******* = " + LongestPalindromicSubstring.longestPalindrome(str));
    }

    @Test
    public void zigZagConversionTest() {
        String str = "LEETCODEISHIRING";
        int numRows = 3;

        Assert.assertEquals("LCIRETOESIIGEDHN", ZigZagConversion.convertT(str, numRows));
    }

    @Test
    public void reverseIntegerTest() {
        int num = -2147483412;
        Assert.assertEquals(-2143847412, ReverseInteger.reverse(num));
    }

    @Test
    public void palindromeNumberTest() {
        int numA = 1221;
        int numB = -121;

        Assert.assertTrue(PalindromeNumber.isPalindromeMethodI(numA));
        Assert.assertFalse(PalindromeNumber.isPalindromeMethodI(numB));

        Assert.assertTrue(PalindromeNumber.isPalindromeMethodII(numA));
        Assert.assertFalse(PalindromeNumber.isPalindromeMethodII(numB));

        Assert.assertTrue(PalindromeNumber.isPalindromeMethodIII(numA));
        Assert.assertFalse(PalindromeNumber.isPalindromeMethodIII(numB));

        Assert.assertTrue(PalindromeNumber.isPalindromeMethodIV(numA));
        Assert.assertFalse(PalindromeNumber.isPalindromeMethodIV(numB));
    }

    @Test
    public void integerToRomanTest() {
        int num = 300;
        Assert.assertEquals("CCC", IntegerToRoman.intToRoman(num));
    }

    @Test
    public void romanToIntegerTest() {
        String param1 = "III";
        String param2 = "IV";
        String param3 = "IX";
        String param4 = "LVIII";
        String param5 = "MCMXCIV";

        Assert.assertEquals(3, RomanToInteger.romanToInt(param1));
        Assert.assertEquals(4, RomanToInteger.romanToInt(param2));
        Assert.assertEquals(9, RomanToInteger.romanToInt(param3));
        Assert.assertEquals(58, RomanToInteger.romanToInt(param4));
        Assert.assertEquals(1994, RomanToInteger.romanToInt(param5));
    }
}
