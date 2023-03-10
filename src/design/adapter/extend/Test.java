package design.adapter.extend;


import design.adapter.interfac.Origin;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description :
 **/
public class Test {

    public static void main(String[] args) {
        Adapter extendAdapter = new Adapter();
        extendAdapter.optA();
        extendAdapter.optB();
        extendAdapter.optC();

    }
}
