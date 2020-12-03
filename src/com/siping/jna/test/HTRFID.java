package com.siping.jna.test;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 * @author Yang Xu
 * @date 2020/9/30 17:34
 * @description:
 */
public class HTRFID {

    public interface JnaCallBackDll extends StdCallLibrary {

//        public static JnaCallBackDll instance = (JnaCallBackDll) Native.loadLibrary("src/main/resources/RFIDAPI.dll",
//                JnaCallBackDll.class);

        boolean SAAT_TCPInit(PointerByReference pointer, String pHostName, int nsocketPort);

        boolean SAAT_Open(Pointer pointer);

        boolean SAAT_YMakeTagUpLoadIDCode(Pointer pointer, byte nOpType, byte nIDType);

        int SAAT_YRevIDMsgDecExpand(Pointer pointer, Pointer nTagType, IntByReference pId, Pointer pBit,
                                    IntByReference nParam1, IntByReference nParam2);

        boolean SAAT_SysInfQuery(Pointer pointer, byte nType, Pointer pPara, Pointer pLen);

    }

   /* public static void main(String[] args) throws Exception {

        PointerByReference pointer = new PointerByReference(Pointer.NULL);
        boolean t = JnaCallBackDll.instance.SAAT_TCPInit(pointer, "192.168.3.219", 7086);
        System.out.println("初始化：" + t);
        t = JnaCallBackDll.instance.SAAT_Open(pointer.getValue());
        System.out.println("打开连接：" + t);
        Thread.sleep(2000);

        Pointer pPara = new Memory(1024);
        Pointer pLen = new Memory(1024);
        t = JnaCallBackDll.instance.SAAT_SysInfQuery(pointer.getValue(), new Byte("00"), pPara, pLen);
        byte[] bytes = pPara.getByteArray(0, 8);
        String sysinfo = new String(bytes);
        System.out.println("读写器名称:" + sysinfo.substring(0, 5));

        t = JnaCallBackDll.instance.SAAT_YMakeTagUpLoadIDCode(pointer.getValue(), new Byte("01"), new Byte("01"));
        System.out.println("主动查询：" + t);

        while (true) {
            Pointer nTagType = new Memory(1024);
            IntByReference pId = new IntByReference();
            pId.setValue(0);
            Pointer pBit = new Memory(1024);
            IntByReference nParam1 = new IntByReference();
            nParam1.setValue(0);
            IntByReference nParam2 = new IntByReference();
            nParam2.setValue(0);
            int result = JnaCallBackDll.instance.SAAT_YRevIDMsgDecExpand(pointer.getValue(), nTagType, pId, pBit,
                    nParam1, nParam2);

            if (result == 1) {
                System.out.println("标签编号" + pId.getValue());
                System.out.println("激励地址" + nParam1.getValue());
                System.out.println("场强强度" + nParam2.getValue());
            }
        }
    }*/
}
//
//TCP参数初始化
//功能：通过参数传入，初始化TCP，为打开连接做准备
//参数：
//  pHandle 		为保存打开的端口句柄
//  pHostName		本机的IP地址，仅在网络通讯模式下有效
//  nsocketPort		网络SOCKET端口
//返回值： true为操作成功, false为操作失败
//


/**
 * bool RFID_API STDCALL SAAT_TCPInit(void** pHandle,char *pHostName,int nsocketPort);  bool RFID_API  STDCALL SAAT_Open(void* pHandle);  bool RFID_API  STDCALL SAAT_SysInfQuery (void* pHandle ,unsigned char nType, unsigned char *pPara, unsigned char *pLen);  bool RFID_API  STDCALL SAAT_YMakeTagUpLoadIDCode ( void *pHandle,unsigned char nOpType,unsigned char nIDType); int RFID_API STDCALL SAAT_YRevIDMsgDecExpand(void *pHandle,unsigned char* nTagType,unsigned int* pId,unsigned char* pBit, int* nParam1, int* nParam2);
 */

//
//打开读写器
//功能：		创建网络连接
//参数：
//  pHandle 		为保存打开的端口句柄
//返回值： true为操作成功, false为操作失败
//
/**  bool RFID_API  STDCALL SAAT_Open(void* pHandle);*/

//
//系统信息查询
//功能：查询读写器参数
//参数：
//	pHandle:		打开的端口句柄
//	nType ：		要查询的参数类型
//					nType           定义							长度
//					0x00			读写器名称						8字节
//					0x01			读写器产品型号					5字节
//					0x02  			读写器出厂产品序列号			8字节
//					0x03   			读写器处理器软件版本号			4字节
//					0x04   			读写器解码单元软件版本号		4字节
//					0x05  			基带电路硬件版本号				4字节
//					0x06			射频电路硬件版本号				4字节
//	pPara：			指向接收读写器参数数据内存的指针
//	pLen： 			pLen指向的内存长度
//返回值： true为操作成功, false为操作失败
/**  bool RFID_API  STDCALL SAAT_SysInfQuery (void* pHandle ,unsigned char nType, unsigned char *pPara, unsigned char *pLen);*/

//
//有源-发送标签主动上传命令
//功能： 有源-发送标签主动上传命令
//参数:
//		pHandle 为已经初始化的端口句柄
//		nOpType: 为操作模式,
//		操作模式：
//		00：对同一个标签的ID码读写器只向上位机返回一次，
//		并要求上位机接收后给予读写器"返回数据确认"，
//		01"：读写器将读取到的所有的标签ID码全部上传到上位机并不要求上位机接收后给予
//			读写器"返回数据确认"，直到上位机下发"关功放"命令后才停止读标签ID码。
//		nIDType 要接收的ID编码
//返回值： true为操作成功, false为操作失败
//
/**  bool RFID_API  STDCALL SAAT_YMakeTagUpLoadIDCode ( void *pHandle,unsigned char nOpType,unsigned char nIDType);*/

//
//接收有源ID码命令
//功能：用于接收ID码, ID码为十进制
//参数:
//		pHandle 	为已经初始化的端口句柄
//      nTagType		为标签标记，0x00表示普通标签；0x01表示温度标签；0x02表示激励标签
//		pId			为十进制int型ID,
//		nBit		为标签标记
//					域	保留	标签ID类型	省电标记	传感标记	按键标记	报警标记	低压标记
//					位	2	       1           1	       1         	1	       1	       1
//      nParam1		温度标签整数 or 激励地址
//      nParam2		温度标签小数 or 场强强度
//返回值： 1为操作成功, 0为操作失败
//
/** int RFID_API STDCALL SAAT_YRevIDMsgDecExpand(void *pHandle,unsigned char* nTagType,unsigned int* pId,unsigned char* pBit, int* nParam1, int* nParam2);*/
