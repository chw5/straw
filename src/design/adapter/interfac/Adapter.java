package design.adapter.interfac;

import design.adapter.ITarget;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 适配器模式-组合关系实现
 **/
public class Adapter implements ITarget {
    private IOrigin iOrigin;

    public Adapter(IOrigin iOrigin){
        this.iOrigin = iOrigin;
    }

    @Override
    public void optA() {
        System.out.println("optA");
        iOrigin.start();;
    }

    @Override
    public void optB() {
        System.out.println("optB");
        iOrigin.processing();
    }

    @Override
    public void optC() {
        System.out.println("optC");
        iOrigin.end();
    }
}
