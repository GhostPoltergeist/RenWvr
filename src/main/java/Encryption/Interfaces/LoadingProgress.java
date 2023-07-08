package Encryption.Interfaces;

import lombok.SneakyThrows;

public interface LoadingProgress {
    @SneakyThrows
    default void sleepWait() {
        Thread.sleep(500);
    }
}