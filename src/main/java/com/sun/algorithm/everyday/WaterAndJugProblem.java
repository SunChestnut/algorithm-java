package com.sun.algorithm.everyday;

import java.math.BigInteger;

/**
 * TODO
 *
 * @author syl
 * @date 2020/03/21 - 15:00
 */
public class WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {

        if ((x + y) < z) {
            return false;
        }

        if (x == 0 || y == 0) {
            return z == 0 || (x + y) == z;
        }

        BigInteger bigX = new BigInteger(x + "");
        BigInteger bigY = new BigInteger(y + "");

        return z % (bigX.gcd(bigY).intValue()) == 0;
    }

    public static void main(String[] args) {
        WaterAndJugProblem solution = new WaterAndJugProblem();
        System.out.println(solution.canMeasureWater(3, 5, 4));
        System.out.println(solution.canMeasureWater(2, 6, 5));
    }
}
