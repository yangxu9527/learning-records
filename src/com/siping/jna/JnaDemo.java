package com.siping.jna;

/**
 * @author Yang Xu
 * @date 2020/8/26 18:44
 * @description:
 */
public class JnaDemo {

    public static void main(String[] args) {
        int value = MyDll.mydll.add(1, 2);
        System.out.println("value = " + value);

        DeleteFile.DELETE_FILE.DeleteFileA("C:\\Users\\yangxu\\Desktop\\test.txt");
    }
}
