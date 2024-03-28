package com.kakao.zodiac.noctua.domain.nio.file;

import com.lmax.disruptor.util.DaemonThreadFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ThreadFactory;

public class NioFileTest {


    public void testConcurrentWrite() throws FileNotFoundException {

        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            RandomAccessFile aFile = new RandomAccessFile("/Users/seonuk/nio-data.txt", "rw");

            FileChannel channel = aFile.getChannel();

            int finalI = i;
            new Thread(() -> {
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                buffer.put(String.valueOf(finalI).getBytes());
                buffer.flip();

                while (buffer.hasRemaining()) {
                    try {
                        channel.write(buffer);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();
        }
    }
}
