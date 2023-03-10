package design.singleton;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 单例-饿汉式(类初始化时就加载)，由JVM保证线程安全
 *
 **/
public class S1 {
    private static S1 instance = new S1();
    private S1(){}

    public static S1 getInstance(){
        return S1.instance;
    }

    public static void main(String[] args) {
        S1 s1 = S1.getInstance();
    }
}
