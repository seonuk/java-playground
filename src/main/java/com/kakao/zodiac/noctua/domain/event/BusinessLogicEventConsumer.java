package com.kakao.zodiac.noctua.domain.event;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.SequenceBarrier;

import java.time.LocalDateTime;

public class BusinessLogicEventConsumer {

    public EventHandler<LongEvent> getEventHandler() {
        return (event, sequence, endOfBatch) -> {
            print(event.getValue(), sequence);
        };
    }
    private void print(Long id, long sequenceId) {
        System.out.println(Thread.currentThread().getName() + '[' + LocalDateTime.now()  + ']'+   "[BusinessLogic] ID is " + id + " sequenceId is " + sequenceId);
    }
}
