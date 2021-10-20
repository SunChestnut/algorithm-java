package com.sun.offer.simple;

/**
 * @author sunyl
 * @date 2021/10/18 8:05 下午
 * @see com.sun.offer.simple
 */
public class Offer11 {

    public static int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray(new int[]{1, 3, 5}));
        System.out.println(minArray(new int[]{1}));
    }

}
