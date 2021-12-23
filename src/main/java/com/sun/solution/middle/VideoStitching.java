package com.sun.solution.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/video-stitching/
 *
 * @author sunyl
 * @date 2021/12/21 2:14 下午
 * @see com.sun.solution.middle
 */
public class VideoStitching {

    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }

    public static void main(String[] args) {
        VideoStitching solution = new VideoStitching();
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 8}};
        System.out.println(solution.videoStitching(clips, 10));
    }
}
