package com.kakao.zodiac.noctua.domain;

import com.kakao.zodiac.noctua.domain.event.JournalEventConsumer;
import com.kakao.zodiac.noctua.domain.event.LongEvent;
import com.kakao.zodiac.noctua.domain.event.BusinessLogicEventConsumer;
import com.kakao.zodiac.noctua.domain.nio.file.NioFileTest;
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.io.FileNotFoundException;
import java.util.concurrent.ThreadFactory;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        NioFileTest nioFileTest = new NioFileTest();
        try {
            nioFileTest.testConcurrentWrite();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
