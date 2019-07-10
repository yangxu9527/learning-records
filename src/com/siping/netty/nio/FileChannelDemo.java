package com.siping.netty.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    /**
     * 使用buffer一般遵循以下步骤：
     * 1.写入数据到buffer
     * 2.调用flip方法
     * 3.从buffer中取数据
     * 4.调用clear或者compact方法
     * 当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取
     * 之前写入到buffer的所有数据。一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()
     * 方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未
     * 读数据的后面。
     * buffer中三个重要的概念capacity、limit、position
     */
    @Test
    public void test() {
        try {
            RandomAccessFile ras = new RandomAccessFile("D:\\02_project\\linux.txt", "rw");
            FileChannel channel = ras.getChannel();
            // 分配一个capactiy为48的buffer
            ByteBuffer buffer = ByteBuffer.allocate(48);
            int read = channel.read(buffer);
            while (read != -1) {
                System.out.println("Read -> " + read);
                // flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。
                // 换句话说，position现在用于标记读的位置，limit表示之前写进了多少个byte、char等 —— 现在能读取多少个byte、char等。
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print(buffer.get());
                }
                buffer.clear();
                read = channel.read(buffer);
            }
            ras.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
