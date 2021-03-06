package com.siping.jna.idcard;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * 使用visual studio 创建可以调用的动态库dll
 * c++代码.h
 * extern "C" TESTDLL_API int add(int a, int b);
 * c++代码.cpp
 * <p>
 * TESTDLL_API int add(int a, int b)
 * {
 * int value = a + b;
 * cout << "dll add value ";
 * printf("%d", value);
 * return value;
 * }
 *
 * @author Yang Xu
 * @date 2020/8/26 19:40
 * @description:
 */
public interface IdCardDll extends Library {

    IdCardDll mydll = Native.load("D:\\04_workspace\\gitee\\learning-records\\src\\dll\\Termb.dll", IdCardDll.class);

    int CVR_InitComm(int port);

}
