package com.siping.jna.idcard;

/**
 * @author Yang Xu
 * @date 2020/8/26 18:44
 * @description:
 */
public class IdCardMain {

    public static void main(String[] args) {
        int value = IdCardDll.mydll.CVR_InitComm(1016);
        System.out.println("value = " + value);

    }
}
