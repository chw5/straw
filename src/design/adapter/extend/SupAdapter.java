package design.adapter.extend;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 适配器模式-类继承方式实现
 **/
public class SupAdapter extends Target{

    @Override
    public void start() {
        System.out.println("SupAdapter start");
        super.start();
    }

    @Override
    public void processing() {
        System.out.println("SupAdapter processing");
        super.processing();
    }

    @Override
    public void end() {
        System.out.println("SupAdapter end");
        super.end();
    }
}
