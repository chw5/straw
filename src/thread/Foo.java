package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 * 线程按顺序打印题
 */
public class Foo {

    private AtomicInteger num = new AtomicInteger(1);

    public void first(Runnable print){
        print.run();
        num.incrementAndGet();
    }

    public void second(Runnable print){
        while (num.get() != 2){};//等待
        print.run();
        num.incrementAndGet();
    }

    public void third(Runnable print){
        while (num.get() != 3){};//等待
        print.run();
        num.incrementAndGet();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread second = new Thread(() -> foo.second(() -> System.out.print("second")));
        Thread third = new Thread(() -> foo.third(()-> System.out.print("third")));
        Thread first = new Thread(() -> foo.first(() -> System.out.print("first")));

        int[] orders = {3,2,1};
        for(int order:orders){
            if (order == 1){
                first.start();
            }else if(order == 2){
                second.start();
            }else if (order == 3){
                third.start();
            }
        }
    }

}
