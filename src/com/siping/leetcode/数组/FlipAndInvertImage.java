package com.siping.leetcode.数组;

import org.junit.Test;

/**
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] ai = A[i];
            int il = ai.length - 1;
            int j = 0;
            int tmp;
            while (il >= j) {
                tmp = ai[il];
                ai[il] = (ai[j] == 1 ? 0 : 1);
                ai[j] = (tmp == 1 ? 0 : 1);
                il--;
                j++;
            }
        }

        return A;
    }

    @Test
    public void test() {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {1, 0}};
        flipAndInvertImage(A);
    }
}
