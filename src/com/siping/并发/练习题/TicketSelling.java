package com.siping.并发.练习题;

/**
 * @author Yang Xu
 * @date 2020/8/21 8:27
 * @description:
 */
public class TicketSelling {


    class Ticket {
        private int count = 100;

        /**
         * 售票
         * @param num
         */
        public void sell(int num) {
            count--;
        }
    }
}
