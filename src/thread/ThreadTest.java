package thread;

/**
 * @Author : wzq
 * @Date : 2023/6/16
 * @Version : 1.0
 * @Description :
 **/
public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println("ThreadTest run");
    }

    public static void main(String[] args) {
        new ThreadTest().start();
    }
}
