package com.kakao.zodiac.noctua.domain.event;

import com.lmax.disruptor.EventHandler;

import java.time.LocalDateTime;

public class JournalEventConsumer {

    public EventHandler<LongEvent> getEventHandler() {
        return (event, sequence, endOfBatch) -> {
            print(event.getValue(), sequence);
        };
    }


    private void print(Long id, long sequenceId) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + '[' + LocalDateTime.now()  + ']'+ "[JournalEvent] ID is " + id + " sequenceId is " + sequenceId);
        Thread.sleep(1000);
    }
}
