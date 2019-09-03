package com.sun.algorithm.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PartTest {

    @Test
    public void removeDuplicatesFromSortedArrayTest() {
        int[] numsT = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Assert.assertEquals(5, RemoveDuplicatesFromSortedArray.removeDuplicatesFromOfficial(numsT));

    }

    @Test
    public void bestTimeToBuyAndSellStockITest() {
        int[] pricesA = {7, 1, 5, 3, 6, 4};
        int[] pricesB = {7, 6, 4, 3, 1};

        Assert.assertEquals(5, BestTimeToBuyAndSellStockI.maxProfitI(pricesA));
        Assert.assertEquals(0, BestTimeToBuyAndSellStockI.maxProfitI(pricesB));

        Assert.assertEquals(5, BestTimeToBuyAndSellStockI.maxProfitII(pricesA));
        Assert.assertEquals(0, BestTimeToBuyAndSellStockI.maxProfitII(pricesB));

        Assert.assertEquals(5, BestTimeToBuyAndSellStockI.maxProfitIII(pricesA));
        Assert.assertEquals(0, BestTimeToBuyAndSellStockI.maxProfitIII(pricesB));


    }

    @Test
    public void bestTimeToBuyAndSellStockIITest() {
        int[] pricesA = {7, 1, 5, 3, 6, 4};
        int[] pricesB = {1, 2, 3, 4, 5};
        int[] pricesC = {7, 6, 4, 3, 1};

        Assert.assertEquals(7, BestTimeToBuyAndSellStockII.maxProfit(pricesA));
        Assert.assertEquals(4, BestTimeToBuyAndSellStockII.maxProfit(pricesB));
        Assert.assertEquals(0, BestTimeToBuyAndSellStockII.maxProfit(pricesC));

    }

    @Test
    public void rotateArrayTest() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
//        RotateArray.rotateI(nums, k);
        RotateArray.rotateII(nums, k);
        System.out.println(Arrays.toString(nums));


    }

    @Test
    public void containsDuplicateTest() {
        int[] numsA = {1, 2, 3, 4};
        int[] numsB = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        Assert.assertFalse(ContainsDuplicate.containsDuplicateI(numsA));
        Assert.assertFalse(ContainsDuplicate.containsDuplicateII(numsA));
        Assert.assertFalse(ContainsDuplicate.containsDuplicateIII(numsA));

        Assert.assertTrue(ContainsDuplicate.containsDuplicateI(numsB));
        Assert.assertTrue(ContainsDuplicate.containsDuplicateII(numsB));
        Assert.assertTrue(ContainsDuplicate.containsDuplicateIII(numsB));
    }
}
