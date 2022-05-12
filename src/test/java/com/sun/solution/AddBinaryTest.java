package com.sun.solution;

import com.sun.solution.simple.AddBinary;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class AddBinaryTest {

    @Autowired
    private AddBinary addBinary;

    @Test
    void calculate() {
    }

    @Test
    void addBinary() {
        String res = addBinary.addBinary("11", "1");
        System.out.println(res);
    }

    @Test
    void maxSubArray() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int pre = 0, maxSum = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            log.info("x = " + x + " , pre = " + pre);
            maxSum = Math.max(pre, maxSum);
        }
        System.out.println("final res = " + maxSum);
    }
}