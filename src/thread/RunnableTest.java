package thread;

/**
 * @Author : wzq
 * @Date : 2023/6/16
 * @Version : 1.0
 * @Description :
 **/
public class RunnableTest implements Runnable{

    @Override
    public void run() {
        System.out.println("RunnableTest run");
    }

    public static void main(String[] args) {
        new Thread(new RunnableTest()).start();
    }
}
