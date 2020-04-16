package com.sun.algorithm.everyday;

/**
 * TODO
 *
 * @author syl
 * @date 2020/03/26 - 17:11
 */
public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {

        int cnt = 0, st = 0, ed = 0;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    st = i;
                    ed = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 4; ++i) {
            for (int step = 0; ; ++step) {
                int tx = st + step * dx[i];
                int ty = ed + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}

        };

        AvailableCapturesForRook soultion = new AvailableCapturesForRook();
        System.out.println(soultion.numRookCaptures(board));
    }
}