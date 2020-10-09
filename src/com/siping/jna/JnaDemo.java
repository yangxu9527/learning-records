package com.siping.jna;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 * @author Yang Xu
 * @date 2020/8/26 18:44
 * @description:
 */
public class JnaDemo {

    public static void main(String[] args) {
        /*int value = MyDll.mydll.add(1, 2);
        System.out.println("value = " + value);*/

        Pointer a = new Memory(1024);
        Pointer b = new Memory(1024);

        MyDll.mydll.GetPeopleIDCode(a, b);
        byte[] bytes = a.getByteArray(0, 1024);
        String idCard = new String(bytes);
        System.out.println("身份证号:" + idCard);

        // DeleteFile.DELETE_FILE.DeleteFileA("C:\\Users\\yangxu\\Desktop\\test.txt");
    }
}
