package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author : wzq
 * @Date : 2023/6/16
 * @Version : 1.0
 * @Description :
 **/
public class CallableTest implements Callable<String> {

    @Override
    public String call() {
        return "CallableTest run";
    }

    public static void main(String[] args) {

        FutureTask<String> task = new FutureTask<>(new CallableTest());
        new Thread(task).start();
        try{
            System.out.println(task.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
