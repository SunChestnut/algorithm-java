package com.sun.algorithm.array;

import java.util.HashMap;

/**
 * 待解决 ❓
 *
 * @author syl
 * @date 2020/01/10 - 09:13
 */
@SuppressWarnings("unchecked")
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        // 初始化数据
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        // 校验数独的有效性
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put((int) num, rows[i].getOrDefault((int) num, 0) + 1);
                    columns[j].put((int) num, columns[j].getOrDefault((int) num, 0) + 1);
                    boxes[boxIndex].put((int) num, boxes[boxIndex].getOrDefault((int) num, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get((int) num) > 1 || columns[j].get((int) num) > 1 || boxes[boxIndex].get((int) num) > 1) {
                        return false;
                    }

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));

    }
}
