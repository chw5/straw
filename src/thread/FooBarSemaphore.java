package thread;

import java.util.concurrent.Semaphore;

/**
 * 交替打印Foobar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBarSemaphore {

    private int n;

    //使用信号量保持同步
    private Semaphore fooSem = new Semaphore(1);
    private Semaphore barSem = new Semaphore(0);

    public FooBarSemaphore(int n){
        this.n=n;
    }

    public void foo(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire();
            runnable.run();
            barSem.release();
        }

    }

    public void bar(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire();
            runnable.run();
            fooSem.release();
        }

    }

    public static void main(String[] args) {
        FooBarSemaphore fooBarSemaphore = new FooBarSemaphore(4);
        new Thread(()-> {
            try {
                fooBarSemaphore.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                fooBarSemaphore.bar(()-> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
