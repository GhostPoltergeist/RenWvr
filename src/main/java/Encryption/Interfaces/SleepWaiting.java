package Encryption.Interfaces;

import lombok.SneakyThrows;

public interface SleepWaiting {
    @SneakyThrows
    default void sleepWait() {
        Thread.sleep(10);
    }
}