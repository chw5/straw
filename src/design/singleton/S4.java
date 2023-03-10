package design.singleton;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 单例懒加载（被调用时实例化）-枚举类(Java虚拟机会保证枚举类型不能被反射并且构造函数只被执行一次)
 *              1.枚举类的构造器只能是私有的
 *              2.既可以避免多线程同步问题；还可以防止通过反射和反序列化来重新创建新的对象。
 **/
public class S4 {

    private S4(){}

    public enum InstanceEnum{
        INSTANCE
        ;
        private S4 instance;

        InstanceEnum(){
            instance = new S4();
        }

        public S4 getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceEnum.INSTANCE.getInstance());
    }

}
