package com.sun.algorithm.array.part;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PartTest {

    @Test
    public void partOneTest() {
        int[] numsT = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(numsT));
        System.out.println(PartOne.removeDuplicatesFromOfficial(numsT));
    }

    @Test
    public void partTwoTest() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(PartTwo.maxProfitOne(prices));
        System.out.println(PartTwo.maxProfitTwo(prices));
        System.out.println(PartTwo.maxProfitThree(prices));
    }
}
