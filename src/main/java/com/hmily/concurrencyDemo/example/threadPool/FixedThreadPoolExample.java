package com.hmily.concurrencyDemo.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class FixedThreadPoolExample {
    public static void main(String[] args) {
        //可控制并发数
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task: {}", index);
                }
            });
        }
        executorService.shutdown();
    }
}
