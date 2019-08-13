package com.sun.algorithm.solution;


import com.sun.algorithm.model.ExampleModel;
import com.sun.algorithm.util.ToolUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SolutionOneTest {

    @Test
    public void solutionOneTest() {
        Instant startTime = Instant.now();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] twoSum = SolutionOne.twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
        ToolUtil.runTime(startTime);
    }

    @Test
    public void solutionThreeTest() {
        String sA = ExampleModel.exampleOne;
        String sB = "abcabcbb";
        Instant startTime = Instant.now();
        System.out.println(SolutionThree.slidingWindow(sA));
        ToolUtil.runTime(startTime);

        Date date2 = new Date();
        System.out.println(SolutionThree.slidingWindowBetter(sB));
        ToolUtil.runTime(startTime);
    }

    @Test
    public void solutionFourTest() {
        Instant startTime = Instant.now();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(SolutionFour.findMedianSortedArrays(nums1, nums2));
        ToolUtil.runTime(startTime);
    }

    @Test
    public void solutionFiveTest() {
        Instant startTime = Instant.now();
        String str = ExampleModel.exampleTwo;
        System.out.println(SolutionFive.longestPalindrome(str));
        ToolUtil.runTime(startTime);
    }

    @Test
    public void solutionSixTest() {
        Instant startTime = Instant.now();
        String str = "LEETCODEISHIRING";
        int numRows = 3;
        String resultStr = "LCIRETOESIIGEDHN";

        System.out.println(resultStr.equals(SolutionSix.convertT(str, numRows)));
        ToolUtil.runTime(startTime);
    }

    @Test
    public void solutionSevenTest() {
        Instant startTime = Instant.now();
        int num = -2147483412;
        System.out.println(SolutionSeven.reverse(num));
        ToolUtil.runTime(startTime);
    }

    @Test
    public void solutionNineTest() {
        Instant now = Instant.now();
        int num = 1221;
        System.out.println(SolutionNine.isPalindromeMethodFour(num));
        ToolUtil.runTime(now);
    }

    @Test
    public void solutionTwelfthTest() {
        Instant startTime = Instant.now();
        int num = 300;
        System.out.println(SolutionTwelfth.intToRoman(num));
        ToolUtil.runTime(startTime);
    }

    @Test
    public void solutionThirteenthTest() {
        String param1 = "III";
        String param2 = "IV";
        String param3 = "IX";
        String param4 = "LVIII";
        String param5 = "MCMXCIV";
        if (SolutionThirteenth.romanToInt(param1) != 3) {
            System.out.println("param1 test fail !");
        } else if (SolutionThirteenth.romanToInt(param2) != 4) {
            System.out.println("param2 test fail !");
        } else if (SolutionThirteenth.romanToInt(param3) != 9) {
            System.out.println("param3 test fail !");
        } else if (SolutionThirteenth.romanToInt(param4) != 58) {
            System.out.println("param4 test fail !");
        } else if (SolutionThirteenth.romanToInt(param5) != 1994) {
            System.out.println("param5 test fail !");
        } else {
            System.out.println("test successful !");
        }
    }
}
