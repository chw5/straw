package thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 * https://leetcode-cn.com/problems/print-zero-even-odd/solution/java-semaphore-by-hans774882968-p2it/
 */
public class ZeroEvenOddSemaphore {

    private int n;

    //使用信号量
    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(0);//奇数
    private Semaphore s3 = new Semaphore(0);//偶数

    public ZeroEvenOddSemaphore(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s1.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0){
                s2.release();
            }else {
                s3.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <=     n; i+=2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public static void main(String[] args) {

        ZeroEvenOddSemaphore zeroEvenOddSemaphore = new ZeroEvenOddSemaphore(2);

        new Thread(()-> {
            try {
                zeroEvenOddSemaphore.zero(i-> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                zeroEvenOddSemaphore.even(i-> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                zeroEvenOddSemaphore.odd(i-> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
