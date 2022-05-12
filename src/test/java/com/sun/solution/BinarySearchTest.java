package com.sun.solution;

import com.sun.solution.simple.BinarySearch;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private final BinarySearch solution = new BinarySearch();

    int[] array1 = new int[]{-1, 0, 3, 5, 9, 12};
    int[] array2 = new int[]{5};


    @Test
    void searchI() {

        Assert.assertEquals(4, solution.searchI(array1, 9));

        Assert.assertEquals(-1, solution.searchI(array1, 2));

        Assert.assertEquals(0, solution.searchI(array2, 5));

        Assert.assertEquals(-1, solution.searchI(array2, 9));
    }

    @Test
    void searchII() {
        Assert.assertEquals(4, solution.searchII(array1, 9));

        Assert.assertEquals(-1, solution.searchII(array1, 2));

        Assert.assertEquals(0, solution.searchII(array2, 5));

        Assert.assertEquals(-1, solution.searchII(array2, 9));
    }

    @Test
    void searchIII() {
        Assert.assertEquals(4, solution.searchIII(array1, 9));

        Assert.assertEquals(-1, solution.searchIII(array1, 2));

        Assert.assertEquals(0, solution.searchIII(array2, 5));

        Assert.assertEquals(-1, solution.searchIII(array2, 9));
    }
}