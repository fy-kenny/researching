package com.example.researching.pattern.command2.device;

import lombok.Builder;
import lombok.Value;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Kenny Fang
 * @since 0.0.1
 */
@Builder
@Value
public class Signal {
    private int value;
    private LocalDateTime createTime;

    public boolean isExpired() {
        return createTime.plus(Duration.ofMillis(80)).isBefore(LocalDateTime.now());
    }

    public boolean isNotExpired() {
        return !isExpired();
    }
}
