package thread;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("fixedThread");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute");
            }
        });

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

        executorService.submit(futureTask);


    }
}
