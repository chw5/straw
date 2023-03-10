package design.adapter.extend;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 被代理类
 **/
public class Origin {

    public void start() {
        System.out.println("target start");
    }


    public void processing() {
        System.out.println("target processing");
    }


    public void end() {
        System.out.println("target end");
    }
}
