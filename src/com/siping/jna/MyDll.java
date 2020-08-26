package com.siping.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * 使用visual studio 创建可以调用的动态库dll
 * c++代码.h
 *      extern "C" TESTDLL_API int add(int a, int b);
 * c++代码.cpp
 *
 * TESTDLL_API int add(int a, int b)
 * {
 *     int value = a + b;
 *     cout << "dll add value ";
 *     printf("%d", value);
 *     return value;
 * }
 * @author Yang Xu
 * @date 2020/8/26 19:40
 * @description:
 */
public interface MyDll extends Library {

    MyDll mydll = Native.load("TestDll", MyDll.class);

    int add(int a, int b);

}
