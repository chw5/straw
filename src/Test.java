import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author : wzq
 * @Date : 2023/4/21
 * @Version : 1.0
 * @Description :
 **/
public class Test {

    public static void main(String[] args) {
//        Object lock = new Object();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程1：开始执行");
//                synchronized (lock){
//                    try{
//                        System.out.println("线程1：进入等待");
//                        lock.wait();
//                        System.out.println("线程1：继续执行");
//                        Thread.sleep(1000L);
//                    }catch (Exception e){
//                        throw new RuntimeException(e);
//                    }
//                }
//                System.out.println("线程1：执行完成");
//            }
//        }).start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        synchronized (lock) {
//            // 唤醒线程
//            System.out.println("执行 notifyAll()");
//            lock.notifyAll();
//        }

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{

            lock.lock();
            try {
                System.out.println("开始");
                condition.await();
                System.out.println("继续");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }

        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        lock.lock();
        try {
            System.out.println("唤醒");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
