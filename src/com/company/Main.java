package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable myCallable = new MyCallable();

        ExecutorService pool = Executors.newFixedThreadPool(4);

        List<Callable<Object>> tasks = new ArrayList<>();
        tasks.add(myCallable);
        tasks.add(myCallable);
        tasks.add(myCallable);

        Object resultOfAnyTask = pool.invokeAny(tasks);

        System.out.println("I showed the message " + resultOfAnyTask + " " + 4 + " times");
        pool.shutdown();
    }
}
