package com.kakao.zodiac.noctua.domain.event;

import com.lmax.disruptor.EventFactory;

public class LongEvent {

    private long value;

    public final static EventFactory EVENT_FACTORY = LongEvent::new;

    public void set(long value) {
        this.value = value;
    }       // 객체를 미리 만들어놓고 처리해야하기 때문에 필요.

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }
}
