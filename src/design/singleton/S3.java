package design.singleton;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 单例懒加载（被调用时实例化）-
 *                静态内部类(实例化外部类，调用外部类的静态方法、静态变量，则外部类必须先进行加载，但只加载一次。)
 **/
public class S3 {

    private S3(){}

    /**
     * 静态内部类
     */
    public static class InnerInstance{
        private static S3 instance = new S3();
        public InnerInstance(){}
    }

    public static S3 getInstance(){
        return InnerInstance.instance;
    }

    public static void main(String[] args) {
        System.out.println(S3.getInstance());
    }
}
