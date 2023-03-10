package design.singleton;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 懒汉式（被调用时创建实例）- 双重检测加锁方式
 **/
public class S2 {

    private static volatile S2 instance = null;

    private S2(){}

    public static S2 getInstance(){
        if (instance != null){
            synchronized (S2.class){
                if (instance != null){
                    instance = new S2();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        S2 s2 = S2.getInstance();
    }
}
