package com.sun.solution;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class FindFirstAndLastPositionOfElementInSortedArrayTest {

    private final FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();

    private final int[] nums1 = new int[]{5, 7, 7, 8, 8, 10};
    private final int[] nums2 = new int[]{1};
    private final int[] nums3 = new int[]{};

    @Test
    void searchRangeTest() {
        int[] res1 = solution.searchRange(nums1, 8);
        Assert.assertArrayEquals(new int[]{3, 4}, res1);

        int[] res2 = solution.searchRange(nums1, 6);
        Assert.assertArrayEquals(new int[]{-1, -1}, res2);

        int[] res3 = solution.searchRange(nums2, 1);
        Assert.assertArrayEquals(new int[]{0, 0}, res3);

        int[] res4 = solution.searchRange(nums3, 0);
        Assert.assertArrayEquals(new int[]{-1,-1}, res4);
    }

    @Test
    void searchRangeFromOfficialTest(){
        int[] res1 = solution.searchRangeFromOfficial(nums1, 8);
        Assert.assertArrayEquals(new int[]{3, 4}, res1);

        int[] res2 = solution.searchRangeFromOfficial(nums1, 6);
        Assert.assertArrayEquals(new int[]{-1, -1}, res2);

        int[] res3 = solution.searchRangeFromOfficial(nums2, 1);
        Assert.assertArrayEquals(new int[]{0, 0}, res3);

        int[] res4 = solution.searchRangeFromOfficial(nums3, 0);
        Assert.assertArrayEquals(new int[]{-1,-1}, res4);
    }
}