package design.adapter.interfac;


/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description :
 **/
public class Test {

    public static void main(String[] args) {

        Adapter adapter = new Adapter(new Origin());
        adapter.optA();
        adapter.optB();
        adapter.optC();

    }
}
