package com.sun.solution;

import com.sun.solution.simple.FindKClosestElements;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class FindKClosestElementsTest {


    private static int[] arr = new int[]{1, 2, 3, 4, 5};

    @Test
    void findClosestElements() {

        FindKClosestElements solution = new FindKClosestElements();
        List<Integer> resList = solution.findClosestElements(arr, 4, 3);

        log.info("resList = {}", resList);

        Assert.assertArrayEquals(new Object[]{1, 2, 3, 4}, resList.toArray());

    }
}