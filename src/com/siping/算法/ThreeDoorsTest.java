package com.siping.算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 三门问题
 */
public class ThreeDoorsTest {

    public static void threeDoorsTest() {
        int changeWinCount = 0;
        int unChangeWinCount = 0;
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            List<Integer> doors = new ArrayList<>(Arrays.asList(0, 1, 2));
            int bonusDoor = random.nextInt(3);
            int selectDoor = random.nextInt(3);
            // 主持人打开一扇空门
            for (int j = 0; j < doors.size(); j++) {
                if (doors.get(j) != bonusDoor && doors.get(j) != selectDoor) {
                    doors.remove(j);
                    break;
                }
            }
            // 获得换门的序号
            int changeDoor = doors.get(0);
            if (changeDoor == selectDoor) {
                changeDoor = doors.get(1);
            }
            // 判断概率
            if (selectDoor == bonusDoor) {
                unChangeWinCount++;
            } else if (changeDoor == bonusDoor) {
                changeWinCount++;
            }
        }
        System.out.println("换门的次数：" + changeWinCount);
        System.out.println("不换门的次数：" + unChangeWinCount);

    }

    @Test
    public void test() {
        threeDoorsTest();
    }
}
