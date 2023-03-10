package design.adapter.interfac;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 被代理类
 **/
public class Origin implements IOrigin {
    @Override
    public void start() {
        System.out.println("target start");
    }

    @Override
    public void processing() {
        System.out.println("target processing");
    }

    @Override
    public void end() {
        System.out.println("target end");
    }
}
