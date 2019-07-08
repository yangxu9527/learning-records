package com.siping.leetcode.数组;

import org.junit.Test;

/**
 * 977. 有序数组的平方
 */
public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        int[] squares = new int[A.length];
        // -1 表示从左边计算右边保持，0表示初始化两边都需要计算，1表示右边计算左边保持
        int pointLeft = 0;
        int left = 0, leftSquare = 0;
        int right = A.length - 1, rightSquare = 0;
        int squaresIndex = right;
        while (left <= right) {
            // 左边
            if (pointLeft == -1) {
                leftSquare = A[left] * A[left];
            } else if (pointLeft == 1) {
                rightSquare = A[right] * A[right];
            } else {
                leftSquare = A[left] * A[left];
                rightSquare = A[right] * A[right];
            }

            if (pointLeft == 0 && leftSquare == rightSquare) {
                squares[squaresIndex] = leftSquare;
                if (squaresIndex > 0) {
                    squaresIndex--;
                    squares[squaresIndex] = rightSquare;
                    squaresIndex--;
                }
                left++;
                right--;
            } else if (leftSquare > rightSquare) {
                squares[squaresIndex] = leftSquare;
                squaresIndex--;
                left++;
                pointLeft = -1;
            } else {
                squares[squaresIndex] = rightSquare;
                squaresIndex--;
                right--;
                pointLeft = 1;
            }
        }

        return squares;
    }

    @Test
    public void test() {
        int[] A = {1};
        int[] B = sortedSquares(A);
        for (int i = 0; i < B.length; i++) {
            System.out.printf("" + B[i]);
        }
    }
}
