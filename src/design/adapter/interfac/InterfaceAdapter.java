package design.adapter.interfac;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 适配器模式-组合关系实现
 **/
public class InterfaceAdapter implements TargetInterface{
    private TargetInterface targetInterface;
    public InterfaceAdapter(Target target){
        this.targetInterface = target;
    }

    @Override
    public void start() {
        System.out.println("adapter start");
        targetInterface.start();;
    }

    @Override
    public void processing() {
        System.out.println("adapter processing");
        targetInterface.processing();
    }

    @Override
    public void end() {
        System.out.println("adapter end");
        targetInterface.end();
    }
}
