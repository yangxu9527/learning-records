package com.siping.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author Yang Xu
 * @date 2020/8/27 8:38
 * @description: 调用微软本地的dll文件
 */
public interface DeleteFile extends Library {
    DeleteFile DELETE_FILE = Native.load("Kernel32", DeleteFile.class);

    /**
     * 删除文件
     *
     * @param lpFileName 删除的文件名
     * @return
     */
    boolean DeleteFileA(String lpFileName);
}
