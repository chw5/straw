package design.adapter.extend;

import design.adapter.ITarget;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 适配器模式-类继承方式实现
 **/
public class Adapter extends Origin implements ITarget {

    @Override
    public void optA() {
        System.out.println("optA");
        this.start();
    }

    @Override
    public void optB() {
        System.out.println("optB");
        this.processing();
    }

    @Override
    public void optC() {
        System.out.println("optC");
        this.end();
    }
}
