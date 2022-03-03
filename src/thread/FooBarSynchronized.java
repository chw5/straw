package thread;

/**
 * 交替打印Foobar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBarSynchronized {

    private int n;

    private volatile boolean type = true;// 标志位，控制执行顺序，true执行printFoo，false执行printBar
    private final Object object=  new Object(); // 锁标志

    public FooBarSynchronized(int n){this.n=n;};

    public void foo(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                while (!type){
                    object.wait();
                }
                type = false;
                runnable.run();
                object.notifyAll();
            }
        }
    }

    public void bar(Runnable runnable) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                while (type){
                    object.wait();
                }
                type = true;
                runnable.run();
                object.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        FooBarSynchronized fooBarSynchronized = new FooBarSynchronized(5);
        new Thread(()-> {
            try {
                fooBarSynchronized.bar(()-> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                fooBarSynchronized.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
