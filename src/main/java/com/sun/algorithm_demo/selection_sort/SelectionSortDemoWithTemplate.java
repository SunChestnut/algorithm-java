package com.sun.algorithm_demo.selection_sort;

/**
 * 选择排序
 *
 * @author syl
 * @date 2020/01/07 - 16:09
 */
@SuppressWarnings("unchecked")
public class SelectionSortDemoWithTemplate {

    /**
     * 算法类不允许产生任何实例
     */
    private SelectionSortDemoWithTemplate() {
    }

    public static void selectionSort(Comparable[] nums) {
        if (nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int minValue = findMinValue(nums, i, nums.length - 1);
            swap(nums, i, minValue);
        }

    }

    /**
     * 寻找[beginIndex,endIndex]区间内的最小值
     *
     * @param nums       初始数组
     * @param beginIndex 起始下标
     * @param endIndex   结束下标
     * @return 数组中的最小元素的下标
     */
    private static int findMinValue(Comparable[] nums, int beginIndex, int endIndex) {
        int minIndex = beginIndex;
        for (int i = beginIndex; i <= endIndex; i++) {
            if (nums[minIndex].compareTo(nums[i]) > 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 数组内交换元素
     *
     * @param nums   初始数组
     * @param aIndex 待交换的元素下标
     * @param bIndex 待交换的元素下标
     */
    private static void swap(Object[] nums, int aIndex, int bIndex) {
        Object temp = nums[aIndex];
        nums[aIndex] = nums[bIndex];
        nums[bIndex] = temp;
    }

    public static void main(String[] args) {

        // 测试Integer
        Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSortDemoWithTemplate.selectionSort(a);

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSortDemoWithTemplate.selectionSort(b);

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectionSortDemoWithTemplate.selectionSort(c);

        // 测试自定义的类 Student
        Student[] students = new Student[4];
        students[0] = new Student("D", 90);
        students[1] = new Student("C", 100);
        students[2] = new Student("B", 95);
        students[3] = new Student("A", 95);
        SelectionSortDemoWithTemplate.selectionSort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
